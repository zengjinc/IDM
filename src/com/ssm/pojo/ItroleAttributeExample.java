package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ItroleAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItroleAttributeExample() {
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

        public Criteria andItroleAttrItroleUuidIsNull() {
            addCriterion("itrole_attr_itrole_uuid is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidIsNotNull() {
            addCriterion("itrole_attr_itrole_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidEqualTo(String value) {
            addCriterion("itrole_attr_itrole_uuid =", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidNotEqualTo(String value) {
            addCriterion("itrole_attr_itrole_uuid <>", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidGreaterThan(String value) {
            addCriterion("itrole_attr_itrole_uuid >", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_itrole_uuid >=", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidLessThan(String value) {
            addCriterion("itrole_attr_itrole_uuid <", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_itrole_uuid <=", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidLike(String value) {
            addCriterion("itrole_attr_itrole_uuid like", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidNotLike(String value) {
            addCriterion("itrole_attr_itrole_uuid not like", value, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidIn(List<String> values) {
            addCriterion("itrole_attr_itrole_uuid in", values, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidNotIn(List<String> values) {
            addCriterion("itrole_attr_itrole_uuid not in", values, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidBetween(String value1, String value2) {
            addCriterion("itrole_attr_itrole_uuid between", value1, value2, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleUuidNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_itrole_uuid not between", value1, value2, "itroleAttrItroleUuid");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyIsNull() {
            addCriterion("itrole_attr_itrole_key is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyIsNotNull() {
            addCriterion("itrole_attr_itrole_key is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyEqualTo(String value) {
            addCriterion("itrole_attr_itrole_key =", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyNotEqualTo(String value) {
            addCriterion("itrole_attr_itrole_key <>", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyGreaterThan(String value) {
            addCriterion("itrole_attr_itrole_key >", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_itrole_key >=", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyLessThan(String value) {
            addCriterion("itrole_attr_itrole_key <", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_itrole_key <=", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyLike(String value) {
            addCriterion("itrole_attr_itrole_key like", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyNotLike(String value) {
            addCriterion("itrole_attr_itrole_key not like", value, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyIn(List<String> values) {
            addCriterion("itrole_attr_itrole_key in", values, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyNotIn(List<String> values) {
            addCriterion("itrole_attr_itrole_key not in", values, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyBetween(String value1, String value2) {
            addCriterion("itrole_attr_itrole_key between", value1, value2, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleKeyNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_itrole_key not between", value1, value2, "itroleAttrItroleKey");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValIsNull() {
            addCriterion("itrole_attr_itrole_val is null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValIsNotNull() {
            addCriterion("itrole_attr_itrole_val is not null");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValEqualTo(String value) {
            addCriterion("itrole_attr_itrole_val =", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValNotEqualTo(String value) {
            addCriterion("itrole_attr_itrole_val <>", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValGreaterThan(String value) {
            addCriterion("itrole_attr_itrole_val >", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValGreaterThanOrEqualTo(String value) {
            addCriterion("itrole_attr_itrole_val >=", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValLessThan(String value) {
            addCriterion("itrole_attr_itrole_val <", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValLessThanOrEqualTo(String value) {
            addCriterion("itrole_attr_itrole_val <=", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValLike(String value) {
            addCriterion("itrole_attr_itrole_val like", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValNotLike(String value) {
            addCriterion("itrole_attr_itrole_val not like", value, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValIn(List<String> values) {
            addCriterion("itrole_attr_itrole_val in", values, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValNotIn(List<String> values) {
            addCriterion("itrole_attr_itrole_val not in", values, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValBetween(String value1, String value2) {
            addCriterion("itrole_attr_itrole_val between", value1, value2, "itroleAttrItroleVal");
            return (Criteria) this;
        }

        public Criteria andItroleAttrItroleValNotBetween(String value1, String value2) {
            addCriterion("itrole_attr_itrole_val not between", value1, value2, "itroleAttrItroleVal");
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