package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccountAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountAttributeExample() {
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

        public Criteria andAcctAttrAcctUuidIsNull() {
            addCriterion("acct_attr_acct_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidIsNotNull() {
            addCriterion("acct_attr_acct_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidEqualTo(String value) {
            addCriterion("acct_attr_acct_uuid =", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidNotEqualTo(String value) {
            addCriterion("acct_attr_acct_uuid <>", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidGreaterThan(String value) {
            addCriterion("acct_attr_acct_uuid >", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_acct_uuid >=", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidLessThan(String value) {
            addCriterion("acct_attr_acct_uuid <", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_acct_uuid <=", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidLike(String value) {
            addCriterion("acct_attr_acct_uuid like", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidNotLike(String value) {
            addCriterion("acct_attr_acct_uuid not like", value, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidIn(List<String> values) {
            addCriterion("acct_attr_acct_uuid in", values, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidNotIn(List<String> values) {
            addCriterion("acct_attr_acct_uuid not in", values, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidBetween(String value1, String value2) {
            addCriterion("acct_attr_acct_uuid between", value1, value2, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrAcctUuidNotBetween(String value1, String value2) {
            addCriterion("acct_attr_acct_uuid not between", value1, value2, "acctAttrAcctUuid");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyIsNull() {
            addCriterion("acct_attr_key is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyIsNotNull() {
            addCriterion("acct_attr_key is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyEqualTo(String value) {
            addCriterion("acct_attr_key =", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyNotEqualTo(String value) {
            addCriterion("acct_attr_key <>", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyGreaterThan(String value) {
            addCriterion("acct_attr_key >", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_key >=", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyLessThan(String value) {
            addCriterion("acct_attr_key <", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_key <=", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyLike(String value) {
            addCriterion("acct_attr_key like", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyNotLike(String value) {
            addCriterion("acct_attr_key not like", value, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyIn(List<String> values) {
            addCriterion("acct_attr_key in", values, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyNotIn(List<String> values) {
            addCriterion("acct_attr_key not in", values, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyBetween(String value1, String value2) {
            addCriterion("acct_attr_key between", value1, value2, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrKeyNotBetween(String value1, String value2) {
            addCriterion("acct_attr_key not between", value1, value2, "acctAttrKey");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValIsNull() {
            addCriterion("acct_attr_val is null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValIsNotNull() {
            addCriterion("acct_attr_val is not null");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValEqualTo(String value) {
            addCriterion("acct_attr_val =", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValNotEqualTo(String value) {
            addCriterion("acct_attr_val <>", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValGreaterThan(String value) {
            addCriterion("acct_attr_val >", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValGreaterThanOrEqualTo(String value) {
            addCriterion("acct_attr_val >=", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValLessThan(String value) {
            addCriterion("acct_attr_val <", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValLessThanOrEqualTo(String value) {
            addCriterion("acct_attr_val <=", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValLike(String value) {
            addCriterion("acct_attr_val like", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValNotLike(String value) {
            addCriterion("acct_attr_val not like", value, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValIn(List<String> values) {
            addCriterion("acct_attr_val in", values, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValNotIn(List<String> values) {
            addCriterion("acct_attr_val not in", values, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValBetween(String value1, String value2) {
            addCriterion("acct_attr_val between", value1, value2, "acctAttrVal");
            return (Criteria) this;
        }

        public Criteria andAcctAttrValNotBetween(String value1, String value2) {
            addCriterion("acct_attr_val not between", value1, value2, "acctAttrVal");
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