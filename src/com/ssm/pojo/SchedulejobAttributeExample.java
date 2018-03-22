package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class SchedulejobAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchedulejobAttributeExample() {
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

        public Criteria andScdAttrScdUuidIsNull() {
            addCriterion("scd_attr_scd_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidIsNotNull() {
            addCriterion("scd_attr_scd_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidEqualTo(String value) {
            addCriterion("scd_attr_scd_uuid =", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidNotEqualTo(String value) {
            addCriterion("scd_attr_scd_uuid <>", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidGreaterThan(String value) {
            addCriterion("scd_attr_scd_uuid >", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidGreaterThanOrEqualTo(String value) {
            addCriterion("scd_attr_scd_uuid >=", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidLessThan(String value) {
            addCriterion("scd_attr_scd_uuid <", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidLessThanOrEqualTo(String value) {
            addCriterion("scd_attr_scd_uuid <=", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidLike(String value) {
            addCriterion("scd_attr_scd_uuid like", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidNotLike(String value) {
            addCriterion("scd_attr_scd_uuid not like", value, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidIn(List<String> values) {
            addCriterion("scd_attr_scd_uuid in", values, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidNotIn(List<String> values) {
            addCriterion("scd_attr_scd_uuid not in", values, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidBetween(String value1, String value2) {
            addCriterion("scd_attr_scd_uuid between", value1, value2, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrScdUuidNotBetween(String value1, String value2) {
            addCriterion("scd_attr_scd_uuid not between", value1, value2, "scdAttrScdUuid");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeIsNull() {
            addCriterion("scd_attr_datatype is null");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeIsNotNull() {
            addCriterion("scd_attr_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeEqualTo(String value) {
            addCriterion("scd_attr_datatype =", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeNotEqualTo(String value) {
            addCriterion("scd_attr_datatype <>", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeGreaterThan(String value) {
            addCriterion("scd_attr_datatype >", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("scd_attr_datatype >=", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeLessThan(String value) {
            addCriterion("scd_attr_datatype <", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeLessThanOrEqualTo(String value) {
            addCriterion("scd_attr_datatype <=", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeLike(String value) {
            addCriterion("scd_attr_datatype like", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeNotLike(String value) {
            addCriterion("scd_attr_datatype not like", value, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeIn(List<String> values) {
            addCriterion("scd_attr_datatype in", values, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeNotIn(List<String> values) {
            addCriterion("scd_attr_datatype not in", values, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeBetween(String value1, String value2) {
            addCriterion("scd_attr_datatype between", value1, value2, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrDatatypeNotBetween(String value1, String value2) {
            addCriterion("scd_attr_datatype not between", value1, value2, "scdAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameIsNull() {
            addCriterion("scd_attr_name is null");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameIsNotNull() {
            addCriterion("scd_attr_name is not null");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameEqualTo(String value) {
            addCriterion("scd_attr_name =", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameNotEqualTo(String value) {
            addCriterion("scd_attr_name <>", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameGreaterThan(String value) {
            addCriterion("scd_attr_name >", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("scd_attr_name >=", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameLessThan(String value) {
            addCriterion("scd_attr_name <", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameLessThanOrEqualTo(String value) {
            addCriterion("scd_attr_name <=", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameLike(String value) {
            addCriterion("scd_attr_name like", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameNotLike(String value) {
            addCriterion("scd_attr_name not like", value, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameIn(List<String> values) {
            addCriterion("scd_attr_name in", values, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameNotIn(List<String> values) {
            addCriterion("scd_attr_name not in", values, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameBetween(String value1, String value2) {
            addCriterion("scd_attr_name between", value1, value2, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrNameNotBetween(String value1, String value2) {
            addCriterion("scd_attr_name not between", value1, value2, "scdAttrName");
            return (Criteria) this;
        }

        public Criteria andScdAttrValIsNull() {
            addCriterion("scd_attr_val is null");
            return (Criteria) this;
        }

        public Criteria andScdAttrValIsNotNull() {
            addCriterion("scd_attr_val is not null");
            return (Criteria) this;
        }

        public Criteria andScdAttrValEqualTo(String value) {
            addCriterion("scd_attr_val =", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValNotEqualTo(String value) {
            addCriterion("scd_attr_val <>", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValGreaterThan(String value) {
            addCriterion("scd_attr_val >", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValGreaterThanOrEqualTo(String value) {
            addCriterion("scd_attr_val >=", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValLessThan(String value) {
            addCriterion("scd_attr_val <", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValLessThanOrEqualTo(String value) {
            addCriterion("scd_attr_val <=", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValLike(String value) {
            addCriterion("scd_attr_val like", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValNotLike(String value) {
            addCriterion("scd_attr_val not like", value, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValIn(List<String> values) {
            addCriterion("scd_attr_val in", values, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValNotIn(List<String> values) {
            addCriterion("scd_attr_val not in", values, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValBetween(String value1, String value2) {
            addCriterion("scd_attr_val between", value1, value2, "scdAttrVal");
            return (Criteria) this;
        }

        public Criteria andScdAttrValNotBetween(String value1, String value2) {
            addCriterion("scd_attr_val not between", value1, value2, "scdAttrVal");
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