package com.atm.service.impl;

import com.atm.Runner;
import com.atm.mapper.StockMapper;
import com.atm.mapper.UserMapper;
import com.atm.mapper.UserMessageMapper;
import com.atm.mapper.UserStockMapper;
import com.atm.pojo.*;
import com.atm.service.StockService;
import com.atm.utils.IO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StocckServiceImpl implements StockService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserStockMapper userStockMapper;

    @Autowired
    private UserStockExample userStockExample;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private StockExample stockExample;

    @Autowired
    private UserMessageMapper userMessageMapper;

    public void stockServiceControl() {
        while(true) {
            showMain();
            String inputValue = IO.cin.next();

            if (inputValue.equals("-1")) {
                // 离开
                break;
            } else if (inputValue.equals("1")) {
                // 购买
                shopStock();
            } else if (inputValue.equals("2")) {
                // 卖出
                sellStock();
            }
            System.err.println("\t\t正在返回 ...");
        }
        System.err.println("\t返回主菜单 ...");
    }

    public void sellStock() {
        int uid = Runner.ID;

        showUserStock();
        System.out.print("请输入要卖出的股票代码: ");
        String sCode = IO.cin.next();
        System.out.print("请输入要卖出的股票数量: ");
        int snum = IO.cin.nextInt();

        // 查询该用户是否有该股票
        List<Map> lst = userStockMapper.selectStocksByUId(uid, sCode);
        if(!lst.isEmpty()) {
            Map t = lst.get(0);
            int sid = (Integer)t.get("s_id");
            int num = (Integer)t.get("us_num");
            float sprice = (Float)t.get("s_price");
            if (num >= snum) {
                try {
                    excuteSell(uid, sid, snum, sprice);
                } catch (Exception e) {
                    System.err.println("交易失败!!!");
                    return;
                }
                System.out.println("成功卖出" + snum + "股" + sCode + "!");

                UserMessage userMessage = new UserMessage();
                userMessage.setmRead(false);
                userMessage.setmDate(new Date());
                userMessage.setmDetail("您已成功售出所持股票("+sCode +") " + snum + " 股。");
                userMessage.setmTitle("投资提醒");
                userMessage.setuId(uid);
                userMessageMapper.insert(userMessage);
            } else {
                System.err.println("您的股票不足 " + snum);
            }
        } else {
            System.err.println("当前用户无该股票!!");
        }
    }

    public void shopStock() {
        System.out.print("请输入您要购买的股票代码：");
        String scode = IO.cin.next();
        System.out.print("请输入您要购买的股票数量: ");
        int snum = IO.cin.nextInt();

        // 获取用户id
        int uid = Runner.ID;

        // 判断该股票是否存在
        stockExample.clear();
        stockExample.createCriteria().andSCodeEqualTo(scode);
        List<Stock> stockList = stockMapper.selectByExample(stockExample);
        if (!stockList.isEmpty()) {
            // 该股票存在, 判断够不够钱
            float currentMoney = userMapper.selectByPrimaryKey(uid).getuMoney();
            float sPrice = stockList.get(0).getsPrice();
            if (snum * sPrice <= currentMoney) {
                int sid = stockList.get(0).getsId();
                try {
                    excuteShop(uid, sid, snum);
                } catch (Exception e) {
                    System.err.println("交易失败!!");
                    return;
                }
                System.out.println("交易成功");

                UserMessage userMessage = new UserMessage();
                userMessage.setmRead(false);
                userMessage.setmDate(new Date());
                userMessage.setmDetail("您已成功购买股票("+ scode +") " + snum + " 股。");
                userMessage.setmTitle("投资提醒");
                userMessage.setuId(uid);
                userMessageMapper.insert(userMessage);
            } else {
                System.err.println("交易失败！ 当前金额不足!");
            }
        } else {
            System.err.println("错误： 该股票代号不存在， 请重试");
        }
    }

    private void showUserStock() {
        int uid = Runner.ID;
        List<Map> stocks = userStockMapper.selectStocksByUId(uid, null);
        System.out.println("当前用户所拥有的股票: ");
        hr();
        if (!stocks.isEmpty()) {
            System.out.printf("%8s%8s%8s%8s\n","代码", "名称", "价格", "拥有数量");
            for (Map t : stocks) {
                System.out.printf("%8s%8s%8s%8s\n", t.get("s_code"), t.get("s_name"), t.get("s_price"), t.get("us_num"));
            }
        } else {
            System.out.println("无");
        }
        hr();

    }


    private void hr() {
        System.out.println("--------------------------------------------------");
    }

    public void excuteShop(int uid, int sid, int snum) {
        // 增加持有
        userStockExample.clear();
        userStockExample.createCriteria().andSIdEqualTo(sid).andUIdEqualTo(uid);
        List<UserStock> userStockList = userStockMapper.selectByExample(userStockExample);
        if (userStockList.isEmpty()) {
            userStockMapper.insert(new UserStock(sid, uid, snum));
        } else {
            int usnum = userStockList.get(0).getUsNum();
            usnum += snum;
            userStockList.get(0).setUsNum(usnum);
            userStockMapper.updateByExampleSelective(userStockList.get(0), userStockExample);
            userStockList.get(0).setUsNum(usnum+snum);
            userStockMapper.updateByExampleSelective(userStockList.get(0), userStockExample);
            throw new RuntimeException();
        }
        // 减钱
        float currentMoney = userMapper.selectByPrimaryKey(uid).getuMoney();
        float sPrice = stockMapper.selectByPrimaryKey(sid).getsPrice();
        User u = new User();
        u.setuMoney(currentMoney-sPrice*snum);
        u.setuId(uid);
        userMapper.updateByPrimaryKeySelective(u);
    }

    public void excuteSell(int uid, int sid, int snum, float sprice) {
        // 减少持有
        userStockExample.clear();
        userStockExample.createCriteria().andUIdEqualTo(uid).andSIdEqualTo(sid);
        List<UserStock> lst = userStockMapper.selectByExample(userStockExample);
        int currentNum = lst.get(0).getUsNum();
        if (currentNum == snum) {
            userStockMapper.deleteByExample(userStockExample);
        } else {
            userStockMapper.updateByExampleSelective(new UserStock(sid, uid, currentNum-snum), userStockExample);
        }
        // 加钱
        float currentMoney = userMapper.selectByPrimaryKey(uid).getuMoney();
        User u = new User();
        u.setuId(uid);
        u.setuMoney(currentMoney + snum*sprice);
        userMapper.updateByPrimaryKeySelective(u);
    }

    /**
     * 显示主界面
     */
    private void showMain() {
        stockExample.clear();
        stockExample.createCriteria();
        List<Stock> stocks = stockMapper.selectByExample(stockExample);
        hr();
        if (!stocks.isEmpty()) {
            System.out.printf("%10s%10s%10s%10s\n", "代码", "名称", "价格", "所属公司");
            for (Stock st : stocks) {
                System.out.printf("%10s%10s%10s%10s\n", st.getsCode(), st.getsName(), st.getsPrice(), st.getsCompany());
            }
        } else {
            System.err.println("当前没有可以购买的股票");
        }
        hr();
        System.out.printf("%13s%8s%8s\n", "1: 购买", "2: 卖出", "-1: 离开");
        hr();
        System.out.print("请选择要操作的动作: ");
    }
}
