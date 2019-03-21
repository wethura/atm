package com.atm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WelfareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WelfareExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWIdIsNull() {
            addCriterion("w_id is null");
            return (Criteria) this;
        }

        public Criteria andWIdIsNotNull() {
            addCriterion("w_id is not null");
            return (Criteria) this;
        }

        public Criteria andWIdEqualTo(Integer value) {
            addCriterion("w_id =", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotEqualTo(Integer value) {
            addCriterion("w_id <>", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThan(Integer value) {
            addCriterion("w_id >", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("w_id >=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThan(Integer value) {
            addCriterion("w_id <", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdLessThanOrEqualTo(Integer value) {
            addCriterion("w_id <=", value, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdIn(List<Integer> values) {
            addCriterion("w_id in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotIn(List<Integer> values) {
            addCriterion("w_id not in", values, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdBetween(Integer value1, Integer value2) {
            addCriterion("w_id between", value1, value2, "wId");
            return (Criteria) this;
        }

        public Criteria andWIdNotBetween(Integer value1, Integer value2) {
            addCriterion("w_id not between", value1, value2, "wId");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andWDateIsNull() {
            addCriterion("w_date is null");
            return (Criteria) this;
        }

        public Criteria andWDateIsNotNull() {
            addCriterion("w_date is not null");
            return (Criteria) this;
        }

        public Criteria andWDateEqualTo(Date value) {
            addCriterion("w_date =", value, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateNotEqualTo(Date value) {
            addCriterion("w_date <>", value, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateGreaterThan(Date value) {
            addCriterion("w_date >", value, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateGreaterThanOrEqualTo(Date value) {
            addCriterion("w_date >=", value, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateLessThan(Date value) {
            addCriterion("w_date <", value, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateLessThanOrEqualTo(Date value) {
            addCriterion("w_date <=", value, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateIn(List<Date> values) {
            addCriterion("w_date in", values, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateNotIn(List<Date> values) {
            addCriterion("w_date not in", values, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateBetween(Date value1, Date value2) {
            addCriterion("w_date between", value1, value2, "wDate");
            return (Criteria) this;
        }

        public Criteria andWDateNotBetween(Date value1, Date value2) {
            addCriterion("w_date not between", value1, value2, "wDate");
            return (Criteria) this;
        }

        public Criteria andWMoneyIsNull() {
            addCriterion("w_money is null");
            return (Criteria) this;
        }

        public Criteria andWMoneyIsNotNull() {
            addCriterion("w_money is not null");
            return (Criteria) this;
        }

        public Criteria andWMoneyEqualTo(Float value) {
            addCriterion("w_money =", value, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyNotEqualTo(Float value) {
            addCriterion("w_money <>", value, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyGreaterThan(Float value) {
            addCriterion("w_money >", value, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyGreaterThanOrEqualTo(Float value) {
            addCriterion("w_money >=", value, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyLessThan(Float value) {
            addCriterion("w_money <", value, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyLessThanOrEqualTo(Float value) {
            addCriterion("w_money <=", value, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyIn(List<Float> values) {
            addCriterion("w_money in", values, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyNotIn(List<Float> values) {
            addCriterion("w_money not in", values, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyBetween(Float value1, Float value2) {
            addCriterion("w_money between", value1, value2, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWMoneyNotBetween(Float value1, Float value2) {
            addCriterion("w_money not between", value1, value2, "wMoney");
            return (Criteria) this;
        }

        public Criteria andWNameIsNull() {
            addCriterion("w_name is null");
            return (Criteria) this;
        }

        public Criteria andWNameIsNotNull() {
            addCriterion("w_name is not null");
            return (Criteria) this;
        }

        public Criteria andWNameEqualTo(String value) {
            addCriterion("w_name =", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotEqualTo(String value) {
            addCriterion("w_name <>", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameGreaterThan(String value) {
            addCriterion("w_name >", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameGreaterThanOrEqualTo(String value) {
            addCriterion("w_name >=", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameLessThan(String value) {
            addCriterion("w_name <", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameLessThanOrEqualTo(String value) {
            addCriterion("w_name <=", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameLike(String value) {
            addCriterion("w_name like", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotLike(String value) {
            addCriterion("w_name not like", value, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameIn(List<String> values) {
            addCriterion("w_name in", values, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotIn(List<String> values) {
            addCriterion("w_name not in", values, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameBetween(String value1, String value2) {
            addCriterion("w_name between", value1, value2, "wName");
            return (Criteria) this;
        }

        public Criteria andWNameNotBetween(String value1, String value2) {
            addCriterion("w_name not between", value1, value2, "wName");
            return (Criteria) this;
        }

        public Criteria andWCardIsNull() {
            addCriterion("w_card is null");
            return (Criteria) this;
        }

        public Criteria andWCardIsNotNull() {
            addCriterion("w_card is not null");
            return (Criteria) this;
        }

        public Criteria andWCardEqualTo(String value) {
            addCriterion("w_card =", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotEqualTo(String value) {
            addCriterion("w_card <>", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardGreaterThan(String value) {
            addCriterion("w_card >", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardGreaterThanOrEqualTo(String value) {
            addCriterion("w_card >=", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardLessThan(String value) {
            addCriterion("w_card <", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardLessThanOrEqualTo(String value) {
            addCriterion("w_card <=", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardLike(String value) {
            addCriterion("w_card like", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotLike(String value) {
            addCriterion("w_card not like", value, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardIn(List<String> values) {
            addCriterion("w_card in", values, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotIn(List<String> values) {
            addCriterion("w_card not in", values, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardBetween(String value1, String value2) {
            addCriterion("w_card between", value1, value2, "wCard");
            return (Criteria) this;
        }

        public Criteria andWCardNotBetween(String value1, String value2) {
            addCriterion("w_card not between", value1, value2, "wCard");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}