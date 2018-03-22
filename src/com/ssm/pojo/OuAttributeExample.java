package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class OuAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OuAttributeExample() {
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

        public Criteria andOuAttrUuidIsNull() {
            addCriterion("ou_attr_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidIsNotNull() {
            addCriterion("ou_attr_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidEqualTo(String value) {
            addCriterion("ou_attr_uuid =", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidNotEqualTo(String value) {
            addCriterion("ou_attr_uuid <>", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidGreaterThan(String value) {
            addCriterion("ou_attr_uuid >", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_uuid >=", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidLessThan(String value) {
            addCriterion("ou_attr_uuid <", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_uuid <=", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidLike(String value) {
            addCriterion("ou_attr_uuid like", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidNotLike(String value) {
            addCriterion("ou_attr_uuid not like", value, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidIn(List<String> values) {
            addCriterion("ou_attr_uuid in", values, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidNotIn(List<String> values) {
            addCriterion("ou_attr_uuid not in", values, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidBetween(String value1, String value2) {
            addCriterion("ou_attr_uuid between", value1, value2, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrUuidNotBetween(String value1, String value2) {
            addCriterion("ou_attr_uuid not between", value1, value2, "ouAttrUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidIsNull() {
            addCriterion("ou_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOuUuidIsNotNull() {
            addCriterion("ou_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOuUuidEqualTo(String value) {
            addCriterion("ou_uuid =", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotEqualTo(String value) {
            addCriterion("ou_uuid <>", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidGreaterThan(String value) {
            addCriterion("ou_uuid >", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidGreaterThanOrEqualTo(String value) {
            addCriterion("ou_uuid >=", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidLessThan(String value) {
            addCriterion("ou_uuid <", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidLessThanOrEqualTo(String value) {
            addCriterion("ou_uuid <=", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidLike(String value) {
            addCriterion("ou_uuid like", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotLike(String value) {
            addCriterion("ou_uuid not like", value, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidIn(List<String> values) {
            addCriterion("ou_uuid in", values, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotIn(List<String> values) {
            addCriterion("ou_uuid not in", values, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidBetween(String value1, String value2) {
            addCriterion("ou_uuid between", value1, value2, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuUuidNotBetween(String value1, String value2) {
            addCriterion("ou_uuid not between", value1, value2, "ouUuid");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyIsNull() {
            addCriterion("ou_attr_def_key is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyIsNotNull() {
            addCriterion("ou_attr_def_key is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyEqualTo(String value) {
            addCriterion("ou_attr_def_key =", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotEqualTo(String value) {
            addCriterion("ou_attr_def_key <>", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyGreaterThan(String value) {
            addCriterion("ou_attr_def_key >", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_key >=", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyLessThan(String value) {
            addCriterion("ou_attr_def_key <", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_def_key <=", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyLike(String value) {
            addCriterion("ou_attr_def_key like", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotLike(String value) {
            addCriterion("ou_attr_def_key not like", value, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyIn(List<String> values) {
            addCriterion("ou_attr_def_key in", values, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotIn(List<String> values) {
            addCriterion("ou_attr_def_key not in", values, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyBetween(String value1, String value2) {
            addCriterion("ou_attr_def_key between", value1, value2, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrDefKeyNotBetween(String value1, String value2) {
            addCriterion("ou_attr_def_key not between", value1, value2, "ouAttrDefKey");
            return (Criteria) this;
        }

        public Criteria andOuAttrValIsNull() {
            addCriterion("ou_attr_val is null");
            return (Criteria) this;
        }

        public Criteria andOuAttrValIsNotNull() {
            addCriterion("ou_attr_val is not null");
            return (Criteria) this;
        }

        public Criteria andOuAttrValEqualTo(String value) {
            addCriterion("ou_attr_val =", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValNotEqualTo(String value) {
            addCriterion("ou_attr_val <>", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValGreaterThan(String value) {
            addCriterion("ou_attr_val >", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValGreaterThanOrEqualTo(String value) {
            addCriterion("ou_attr_val >=", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValLessThan(String value) {
            addCriterion("ou_attr_val <", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValLessThanOrEqualTo(String value) {
            addCriterion("ou_attr_val <=", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValLike(String value) {
            addCriterion("ou_attr_val like", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValNotLike(String value) {
            addCriterion("ou_attr_val not like", value, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValIn(List<String> values) {
            addCriterion("ou_attr_val in", values, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValNotIn(List<String> values) {
            addCriterion("ou_attr_val not in", values, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValBetween(String value1, String value2) {
            addCriterion("ou_attr_val between", value1, value2, "ouAttrVal");
            return (Criteria) this;
        }

        public Criteria andOuAttrValNotBetween(String value1, String value2) {
            addCriterion("ou_attr_val not between", value1, value2, "ouAttrVal");
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