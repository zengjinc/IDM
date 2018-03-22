package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccessControlPermExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccessControlPermExample() {
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

        public Criteria andRoleCodeIsNull() {
            addCriterion("role_code is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("role_code is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(Integer value) {
            addCriterion("role_code =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(Integer value) {
            addCriterion("role_code <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(Integer value) {
            addCriterion("role_code >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_code >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(Integer value) {
            addCriterion("role_code <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(Integer value) {
            addCriterion("role_code <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<Integer> values) {
            addCriterion("role_code in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<Integer> values) {
            addCriterion("role_code not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(Integer value1, Integer value2) {
            addCriterion("role_code between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("role_code not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeIsNull() {
            addCriterion("obj_code is null");
            return (Criteria) this;
        }

        public Criteria andObjCodeIsNotNull() {
            addCriterion("obj_code is not null");
            return (Criteria) this;
        }

        public Criteria andObjCodeEqualTo(Integer value) {
            addCriterion("obj_code =", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeNotEqualTo(Integer value) {
            addCriterion("obj_code <>", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeGreaterThan(Integer value) {
            addCriterion("obj_code >", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("obj_code >=", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeLessThan(Integer value) {
            addCriterion("obj_code <", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeLessThanOrEqualTo(Integer value) {
            addCriterion("obj_code <=", value, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeIn(List<Integer> values) {
            addCriterion("obj_code in", values, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeNotIn(List<Integer> values) {
            addCriterion("obj_code not in", values, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeBetween(Integer value1, Integer value2) {
            addCriterion("obj_code between", value1, value2, "objCode");
            return (Criteria) this;
        }

        public Criteria andObjCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("obj_code not between", value1, value2, "objCode");
            return (Criteria) this;
        }

        public Criteria andActCodeIsNull() {
            addCriterion("act_code is null");
            return (Criteria) this;
        }

        public Criteria andActCodeIsNotNull() {
            addCriterion("act_code is not null");
            return (Criteria) this;
        }

        public Criteria andActCodeEqualTo(Integer value) {
            addCriterion("act_code =", value, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeNotEqualTo(Integer value) {
            addCriterion("act_code <>", value, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeGreaterThan(Integer value) {
            addCriterion("act_code >", value, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("act_code >=", value, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeLessThan(Integer value) {
            addCriterion("act_code <", value, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeLessThanOrEqualTo(Integer value) {
            addCriterion("act_code <=", value, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeIn(List<Integer> values) {
            addCriterion("act_code in", values, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeNotIn(List<Integer> values) {
            addCriterion("act_code not in", values, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeBetween(Integer value1, Integer value2) {
            addCriterion("act_code between", value1, value2, "actCode");
            return (Criteria) this;
        }

        public Criteria andActCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("act_code not between", value1, value2, "actCode");
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