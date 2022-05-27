package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A DashboardConfig.
 */
@Document(collection = "dashboard_config")
public class DashboardConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("margin")
    private Integer margin;

    @Field("outer_margin")
    private Boolean outerMargin;

    @Field("outer_margin_top")
    private Integer outerMarginTop;

    @Field("use_transform_positioning")
    private Boolean useTransformPositioning;

    @Field("mobile_breakpoint")
    private Integer mobileBreakpoint;

    @Field("use_body_for_breakpoint")
    private Boolean useBodyForBreakpoint;

    @Field("min_cols")
    private Integer minCols;

    @Field("max_cols")
    private Integer maxCols;

    @Field("min_rows")
    private Integer minRows;

    @Field("max_rows")
    private Integer maxRows;

    @Field("max_item_cols")
    private Integer maxItemCols;

    @Field("min_item_cols")
    private Integer minItemCols;

    @Field("max_item_rows")
    private Integer maxItemRows;

    @Field("min_item_rows")
    private Integer minItemRows;

    @Field("max_item_area")
    private Integer maxItemArea;

    @Field("min_item_area")
    private Integer minItemArea;

    @Field("default_item_cols")
    private Integer defaultItemCols;

    @Field("default_item_rows")
    private Integer defaultItemRows;

    @Field("ignore_margin_in_row")
    private Boolean ignoreMarginInRow;

    @Field("draggable")
    private Boolean draggable;

    @Field("resizable")
    private Boolean resizable;

    @DBRef
    @Field("userProfile")
    @JsonIgnoreProperties(value = { "dashboardItems", "dashboardLayout", "dashboardConfig" }, allowSetters = true)
    private Set<UserProfile> userProfiles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public DashboardConfig id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMargin() {
        return this.margin;
    }

    public DashboardConfig margin(Integer margin) {
        this.setMargin(margin);
        return this;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    public Boolean getOuterMargin() {
        return this.outerMargin;
    }

    public DashboardConfig outerMargin(Boolean outerMargin) {
        this.setOuterMargin(outerMargin);
        return this;
    }

    public void setOuterMargin(Boolean outerMargin) {
        this.outerMargin = outerMargin;
    }

    public Integer getOuterMarginTop() {
        return this.outerMarginTop;
    }

    public DashboardConfig outerMarginTop(Integer outerMarginTop) {
        this.setOuterMarginTop(outerMarginTop);
        return this;
    }

    public void setOuterMarginTop(Integer outerMarginTop) {
        this.outerMarginTop = outerMarginTop;
    }

    public Boolean getUseTransformPositioning() {
        return this.useTransformPositioning;
    }

    public DashboardConfig useTransformPositioning(Boolean useTransformPositioning) {
        this.setUseTransformPositioning(useTransformPositioning);
        return this;
    }

    public void setUseTransformPositioning(Boolean useTransformPositioning) {
        this.useTransformPositioning = useTransformPositioning;
    }

    public Integer getMobileBreakpoint() {
        return this.mobileBreakpoint;
    }

    public DashboardConfig mobileBreakpoint(Integer mobileBreakpoint) {
        this.setMobileBreakpoint(mobileBreakpoint);
        return this;
    }

    public void setMobileBreakpoint(Integer mobileBreakpoint) {
        this.mobileBreakpoint = mobileBreakpoint;
    }

    public Boolean getUseBodyForBreakpoint() {
        return this.useBodyForBreakpoint;
    }

    public DashboardConfig useBodyForBreakpoint(Boolean useBodyForBreakpoint) {
        this.setUseBodyForBreakpoint(useBodyForBreakpoint);
        return this;
    }

    public void setUseBodyForBreakpoint(Boolean useBodyForBreakpoint) {
        this.useBodyForBreakpoint = useBodyForBreakpoint;
    }

    public Integer getMinCols() {
        return this.minCols;
    }

    public DashboardConfig minCols(Integer minCols) {
        this.setMinCols(minCols);
        return this;
    }

    public void setMinCols(Integer minCols) {
        this.minCols = minCols;
    }

    public Integer getMaxCols() {
        return this.maxCols;
    }

    public DashboardConfig maxCols(Integer maxCols) {
        this.setMaxCols(maxCols);
        return this;
    }

    public void setMaxCols(Integer maxCols) {
        this.maxCols = maxCols;
    }

    public Integer getMinRows() {
        return this.minRows;
    }

    public DashboardConfig minRows(Integer minRows) {
        this.setMinRows(minRows);
        return this;
    }

    public void setMinRows(Integer minRows) {
        this.minRows = minRows;
    }

    public Integer getMaxRows() {
        return this.maxRows;
    }

    public DashboardConfig maxRows(Integer maxRows) {
        this.setMaxRows(maxRows);
        return this;
    }

    public void setMaxRows(Integer maxRows) {
        this.maxRows = maxRows;
    }

    public Integer getMaxItemCols() {
        return this.maxItemCols;
    }

    public DashboardConfig maxItemCols(Integer maxItemCols) {
        this.setMaxItemCols(maxItemCols);
        return this;
    }

    public void setMaxItemCols(Integer maxItemCols) {
        this.maxItemCols = maxItemCols;
    }

    public Integer getMinItemCols() {
        return this.minItemCols;
    }

    public DashboardConfig minItemCols(Integer minItemCols) {
        this.setMinItemCols(minItemCols);
        return this;
    }

    public void setMinItemCols(Integer minItemCols) {
        this.minItemCols = minItemCols;
    }

    public Integer getMaxItemRows() {
        return this.maxItemRows;
    }

    public DashboardConfig maxItemRows(Integer maxItemRows) {
        this.setMaxItemRows(maxItemRows);
        return this;
    }

    public void setMaxItemRows(Integer maxItemRows) {
        this.maxItemRows = maxItemRows;
    }

    public Integer getMinItemRows() {
        return this.minItemRows;
    }

    public DashboardConfig minItemRows(Integer minItemRows) {
        this.setMinItemRows(minItemRows);
        return this;
    }

    public void setMinItemRows(Integer minItemRows) {
        this.minItemRows = minItemRows;
    }

    public Integer getMaxItemArea() {
        return this.maxItemArea;
    }

    public DashboardConfig maxItemArea(Integer maxItemArea) {
        this.setMaxItemArea(maxItemArea);
        return this;
    }

    public void setMaxItemArea(Integer maxItemArea) {
        this.maxItemArea = maxItemArea;
    }

    public Integer getMinItemArea() {
        return this.minItemArea;
    }

    public DashboardConfig minItemArea(Integer minItemArea) {
        this.setMinItemArea(minItemArea);
        return this;
    }

    public void setMinItemArea(Integer minItemArea) {
        this.minItemArea = minItemArea;
    }

    public Integer getDefaultItemCols() {
        return this.defaultItemCols;
    }

    public DashboardConfig defaultItemCols(Integer defaultItemCols) {
        this.setDefaultItemCols(defaultItemCols);
        return this;
    }

    public void setDefaultItemCols(Integer defaultItemCols) {
        this.defaultItemCols = defaultItemCols;
    }

    public Integer getDefaultItemRows() {
        return this.defaultItemRows;
    }

    public DashboardConfig defaultItemRows(Integer defaultItemRows) {
        this.setDefaultItemRows(defaultItemRows);
        return this;
    }

    public void setDefaultItemRows(Integer defaultItemRows) {
        this.defaultItemRows = defaultItemRows;
    }

    public Boolean getIgnoreMarginInRow() {
        return this.ignoreMarginInRow;
    }

    public DashboardConfig ignoreMarginInRow(Boolean ignoreMarginInRow) {
        this.setIgnoreMarginInRow(ignoreMarginInRow);
        return this;
    }

    public void setIgnoreMarginInRow(Boolean ignoreMarginInRow) {
        this.ignoreMarginInRow = ignoreMarginInRow;
    }

    public Boolean getDraggable() {
        return this.draggable;
    }

    public DashboardConfig draggable(Boolean draggable) {
        this.setDraggable(draggable);
        return this;
    }

    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }

    public Boolean getResizable() {
        return this.resizable;
    }

    public DashboardConfig resizable(Boolean resizable) {
        this.setResizable(resizable);
        return this;
    }

    public void setResizable(Boolean resizable) {
        this.resizable = resizable;
    }

    public Set<UserProfile> getUserProfiles() {
        return this.userProfiles;
    }

    public void setUserProfiles(Set<UserProfile> userProfiles) {
        if (this.userProfiles != null) {
            this.userProfiles.forEach(i -> i.setDashboardConfig(null));
        }
        if (userProfiles != null) {
            userProfiles.forEach(i -> i.setDashboardConfig(this));
        }
        this.userProfiles = userProfiles;
    }

    public DashboardConfig userProfiles(Set<UserProfile> userProfiles) {
        this.setUserProfiles(userProfiles);
        return this;
    }

    public DashboardConfig addUserProfile(UserProfile userProfile) {
        this.userProfiles.add(userProfile);
        userProfile.setDashboardConfig(this);
        return this;
    }

    public DashboardConfig removeUserProfile(UserProfile userProfile) {
        this.userProfiles.remove(userProfile);
        userProfile.setDashboardConfig(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DashboardConfig)) {
            return false;
        }
        return id != null && id.equals(((DashboardConfig) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DashboardConfig{" +
            "id=" + getId() +
            ", margin=" + getMargin() +
            ", outerMargin='" + getOuterMargin() + "'" +
            ", outerMarginTop=" + getOuterMarginTop() +
            ", useTransformPositioning='" + getUseTransformPositioning() + "'" +
            ", mobileBreakpoint=" + getMobileBreakpoint() +
            ", useBodyForBreakpoint='" + getUseBodyForBreakpoint() + "'" +
            ", minCols=" + getMinCols() +
            ", maxCols=" + getMaxCols() +
            ", minRows=" + getMinRows() +
            ", maxRows=" + getMaxRows() +
            ", maxItemCols=" + getMaxItemCols() +
            ", minItemCols=" + getMinItemCols() +
            ", maxItemRows=" + getMaxItemRows() +
            ", minItemRows=" + getMinItemRows() +
            ", maxItemArea=" + getMaxItemArea() +
            ", minItemArea=" + getMinItemArea() +
            ", defaultItemCols=" + getDefaultItemCols() +
            ", defaultItemRows=" + getDefaultItemRows() +
            ", ignoreMarginInRow='" + getIgnoreMarginInRow() + "'" +
            ", draggable='" + getDraggable() + "'" +
            ", resizable='" + getResizable() + "'" +
            "}";
    }
}
