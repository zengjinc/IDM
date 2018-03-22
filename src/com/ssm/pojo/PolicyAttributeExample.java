package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class PolicyAttributeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyAttributeExample() {
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

        public Criteria andPolAttrPolUuidIsNull() {
            addCriterion("pol_attr_pol_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidIsNotNull() {
            addCriterion("pol_attr_pol_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidEqualTo(String value) {
            addCriterion("pol_attr_pol_uuid =", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidNotEqualTo(String value) {
            addCriterion("pol_attr_pol_uuid <>", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidGreaterThan(String value) {
            addCriterion("pol_attr_pol_uuid >", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pol_attr_pol_uuid >=", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidLessThan(String value) {
            addCriterion("pol_attr_pol_uuid <", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidLessThanOrEqualTo(String value) {
            addCriterion("pol_attr_pol_uuid <=", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidLike(String value) {
            addCriterion("pol_attr_pol_uuid like", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidNotLike(String value) {
            addCriterion("pol_attr_pol_uuid not like", value, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidIn(List<String> values) {
            addCriterion("pol_attr_pol_uuid in", values, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidNotIn(List<String> values) {
            addCriterion("pol_attr_pol_uuid not in", values, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidBetween(String value1, String value2) {
            addCriterion("pol_attr_pol_uuid between", value1, value2, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrPolUuidNotBetween(String value1, String value2) {
            addCriterion("pol_attr_pol_uuid not between", value1, value2, "polAttrPolUuid");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeIsNull() {
            addCriterion("pol_attr_datatype is null");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeIsNotNull() {
            addCriterion("pol_attr_datatype is not null");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeEqualTo(String value) {
            addCriterion("pol_attr_datatype =", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeNotEqualTo(String value) {
            addCriterion("pol_attr_datatype <>", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeGreaterThan(String value) {
            addCriterion("pol_attr_datatype >", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeGreaterThanOrEqualTo(String value) {
            addCriterion("pol_attr_datatype >=", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeLessThan(String value) {
            addCriterion("pol_attr_datatype <", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeLessThanOrEqualTo(String value) {
            addCriterion("pol_attr_datatype <=", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeLike(String value) {
            addCriterion("pol_attr_datatype like", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeNotLike(String value) {
            addCriterion("pol_attr_datatype not like", value, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeIn(List<String> values) {
            addCriterion("pol_attr_datatype in", values, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeNotIn(List<String> values) {
            addCriterion("pol_attr_datatype not in", values, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeBetween(String value1, String value2) {
            addCriterion("pol_attr_datatype between", value1, value2, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrDatatypeNotBetween(String value1, String value2) {
            addCriterion("pol_attr_datatype not between", value1, value2, "polAttrDatatype");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameIsNull() {
            addCriterion("pol_attr_name is null");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameIsNotNull() {
            addCriterion("pol_attr_name is not null");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameEqualTo(String value) {
            addCriterion("pol_attr_name =", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameNotEqualTo(String value) {
            addCriterion("pol_attr_name <>", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameGreaterThan(String value) {
            addCriterion("pol_attr_name >", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameGreaterThanOrEqualTo(String value) {
            addCriterion("pol_attr_name >=", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameLessThan(String value) {
            addCriterion("pol_attr_name <", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameLessThanOrEqualTo(String value) {
            addCriterion("pol_attr_name <=", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameLike(String value) {
            addCriterion("pol_attr_name like", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameNotLike(String value) {
            addCriterion("pol_attr_name not like", value, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameIn(List<String> values) {
            addCriterion("pol_attr_name in", values, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameNotIn(List<String> values) {
            addCriterion("pol_attr_name not in", values, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameBetween(String value1, String value2) {
            addCriterion("pol_attr_name between", value1, value2, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrNameNotBetween(String value1, String value2) {
            addCriterion("pol_attr_name not between", value1, value2, "polAttrName");
            return (Criteria) this;
        }

        public Criteria andPolAttrValIsNull() {
            addCriterion("pol_attr_val is null");
            return (Criteria) this;
        }

        public Criteria andPolAttrValIsNotNull() {
            addCriterion("pol_attr_val is not null");
            return (Criteria) this;
        }

        public Criteria andPolAttrValEqualTo(String value) {
            addCriterion("pol_attr_val =", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValNotEqualTo(String value) {
            addCriterion("pol_attr_val <>", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValGreaterThan(String value) {
            addCriterion("pol_attr_val >", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValGreaterThanOrEqualTo(String value) {
            addCriterion("pol_attr_val >=", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValLessThan(String value) {
            addCriterion("pol_attr_val <", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValLessThanOrEqualTo(String value) {
            addCriterion("pol_attr_val <=", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValLike(String value) {
            addCriterion("pol_attr_val like", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValNotLike(String value) {
            addCriterion("pol_attr_val not like", value, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValIn(List<String> values) {
            addCriterion("pol_attr_val in", values, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValNotIn(List<String> values) {
            addCriterion("pol_attr_val not in", values, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValBetween(String value1, String value2) {
            addCriterion("pol_attr_val between", value1, value2, "polAttrVal");
            return (Criteria) this;
        }

        public Criteria andPolAttrValNotBetween(String value1, String value2) {
            addCriterion("pol_attr_val not between", value1, value2, "polAttrVal");
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