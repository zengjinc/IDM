package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class OuAncestorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OuAncestorExample() {
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

        public Criteria andOuDescendentIsNull() {
            addCriterion("ou_descendent is null");
            return (Criteria) this;
        }

        public Criteria andOuDescendentIsNotNull() {
            addCriterion("ou_descendent is not null");
            return (Criteria) this;
        }

        public Criteria andOuDescendentEqualTo(String value) {
            addCriterion("ou_descendent =", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentNotEqualTo(String value) {
            addCriterion("ou_descendent <>", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentGreaterThan(String value) {
            addCriterion("ou_descendent >", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentGreaterThanOrEqualTo(String value) {
            addCriterion("ou_descendent >=", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentLessThan(String value) {
            addCriterion("ou_descendent <", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentLessThanOrEqualTo(String value) {
            addCriterion("ou_descendent <=", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentLike(String value) {
            addCriterion("ou_descendent like", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentNotLike(String value) {
            addCriterion("ou_descendent not like", value, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentIn(List<String> values) {
            addCriterion("ou_descendent in", values, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentNotIn(List<String> values) {
            addCriterion("ou_descendent not in", values, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentBetween(String value1, String value2) {
            addCriterion("ou_descendent between", value1, value2, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuDescendentNotBetween(String value1, String value2) {
            addCriterion("ou_descendent not between", value1, value2, "ouDescendent");
            return (Criteria) this;
        }

        public Criteria andOuAncestorIsNull() {
            addCriterion("ou_ancestor is null");
            return (Criteria) this;
        }

        public Criteria andOuAncestorIsNotNull() {
            addCriterion("ou_ancestor is not null");
            return (Criteria) this;
        }

        public Criteria andOuAncestorEqualTo(String value) {
            addCriterion("ou_ancestor =", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorNotEqualTo(String value) {
            addCriterion("ou_ancestor <>", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorGreaterThan(String value) {
            addCriterion("ou_ancestor >", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorGreaterThanOrEqualTo(String value) {
            addCriterion("ou_ancestor >=", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorLessThan(String value) {
            addCriterion("ou_ancestor <", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorLessThanOrEqualTo(String value) {
            addCriterion("ou_ancestor <=", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorLike(String value) {
            addCriterion("ou_ancestor like", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorNotLike(String value) {
            addCriterion("ou_ancestor not like", value, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorIn(List<String> values) {
            addCriterion("ou_ancestor in", values, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorNotIn(List<String> values) {
            addCriterion("ou_ancestor not in", values, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorBetween(String value1, String value2) {
            addCriterion("ou_ancestor between", value1, value2, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuAncestorNotBetween(String value1, String value2) {
            addCriterion("ou_ancestor not between", value1, value2, "ouAncestor");
            return (Criteria) this;
        }

        public Criteria andOuDepthIsNull() {
            addCriterion("ou_depth is null");
            return (Criteria) this;
        }

        public Criteria andOuDepthIsNotNull() {
            addCriterion("ou_depth is not null");
            return (Criteria) this;
        }

        public Criteria andOuDepthEqualTo(Integer value) {
            addCriterion("ou_depth =", value, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthNotEqualTo(Integer value) {
            addCriterion("ou_depth <>", value, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthGreaterThan(Integer value) {
            addCriterion("ou_depth >", value, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ou_depth >=", value, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthLessThan(Integer value) {
            addCriterion("ou_depth <", value, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthLessThanOrEqualTo(Integer value) {
            addCriterion("ou_depth <=", value, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthIn(List<Integer> values) {
            addCriterion("ou_depth in", values, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthNotIn(List<Integer> values) {
            addCriterion("ou_depth not in", values, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthBetween(Integer value1, Integer value2) {
            addCriterion("ou_depth between", value1, value2, "ouDepth");
            return (Criteria) this;
        }

        public Criteria andOuDepthNotBetween(Integer value1, Integer value2) {
            addCriterion("ou_depth not between", value1, value2, "ouDepth");
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