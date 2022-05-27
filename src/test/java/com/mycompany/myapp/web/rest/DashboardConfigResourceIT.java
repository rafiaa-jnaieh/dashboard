package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.DashboardConfig;
import com.mycompany.myapp.repository.DashboardConfigRepository;
import com.mycompany.myapp.service.dto.DashboardConfigDTO;
import com.mycompany.myapp.service.mapper.DashboardConfigMapper;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Integration tests for the {@link DashboardConfigResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DashboardConfigResourceIT {

    private static final Integer DEFAULT_MARGIN = 1;
    private static final Integer UPDATED_MARGIN = 2;

    private static final Boolean DEFAULT_OUTER_MARGIN = false;
    private static final Boolean UPDATED_OUTER_MARGIN = true;

    private static final Integer DEFAULT_OUTER_MARGIN_TOP = 1;
    private static final Integer UPDATED_OUTER_MARGIN_TOP = 2;

    private static final Boolean DEFAULT_USE_TRANSFORM_POSITIONING = false;
    private static final Boolean UPDATED_USE_TRANSFORM_POSITIONING = true;

    private static final Integer DEFAULT_MOBILE_BREAKPOINT = 1;
    private static final Integer UPDATED_MOBILE_BREAKPOINT = 2;

    private static final Boolean DEFAULT_USE_BODY_FOR_BREAKPOINT = false;
    private static final Boolean UPDATED_USE_BODY_FOR_BREAKPOINT = true;

    private static final Integer DEFAULT_MIN_COLS = 1;
    private static final Integer UPDATED_MIN_COLS = 2;

    private static final Integer DEFAULT_MAX_COLS = 1;
    private static final Integer UPDATED_MAX_COLS = 2;

    private static final Integer DEFAULT_MIN_ROWS = 1;
    private static final Integer UPDATED_MIN_ROWS = 2;

    private static final Integer DEFAULT_MAX_ROWS = 1;
    private static final Integer UPDATED_MAX_ROWS = 2;

    private static final Integer DEFAULT_MAX_ITEM_COLS = 1;
    private static final Integer UPDATED_MAX_ITEM_COLS = 2;

    private static final Integer DEFAULT_MIN_ITEM_COLS = 1;
    private static final Integer UPDATED_MIN_ITEM_COLS = 2;

    private static final Integer DEFAULT_MAX_ITEM_ROWS = 1;
    private static final Integer UPDATED_MAX_ITEM_ROWS = 2;

    private static final Integer DEFAULT_MIN_ITEM_ROWS = 1;
    private static final Integer UPDATED_MIN_ITEM_ROWS = 2;

    private static final Integer DEFAULT_MAX_ITEM_AREA = 1;
    private static final Integer UPDATED_MAX_ITEM_AREA = 2;

    private static final Integer DEFAULT_MIN_ITEM_AREA = 1;
    private static final Integer UPDATED_MIN_ITEM_AREA = 2;

    private static final Integer DEFAULT_DEFAULT_ITEM_COLS = 1;
    private static final Integer UPDATED_DEFAULT_ITEM_COLS = 2;

    private static final Integer DEFAULT_DEFAULT_ITEM_ROWS = 1;
    private static final Integer UPDATED_DEFAULT_ITEM_ROWS = 2;

    private static final Boolean DEFAULT_IGNORE_MARGIN_IN_ROW = false;
    private static final Boolean UPDATED_IGNORE_MARGIN_IN_ROW = true;

    private static final Boolean DEFAULT_DRAGGABLE = false;
    private static final Boolean UPDATED_DRAGGABLE = true;

    private static final Boolean DEFAULT_RESIZABLE = false;
    private static final Boolean UPDATED_RESIZABLE = true;

    private static final String ENTITY_API_URL = "/api/dashboard-configs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private DashboardConfigRepository dashboardConfigRepository;

    @Autowired
    private DashboardConfigMapper dashboardConfigMapper;

    @Autowired
    private MockMvc restDashboardConfigMockMvc;

    private DashboardConfig dashboardConfig;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DashboardConfig createEntity() {
        DashboardConfig dashboardConfig = new DashboardConfig()
            .margin(DEFAULT_MARGIN)
            .outerMargin(DEFAULT_OUTER_MARGIN)
            .outerMarginTop(DEFAULT_OUTER_MARGIN_TOP)
            .useTransformPositioning(DEFAULT_USE_TRANSFORM_POSITIONING)
            .mobileBreakpoint(DEFAULT_MOBILE_BREAKPOINT)
            .useBodyForBreakpoint(DEFAULT_USE_BODY_FOR_BREAKPOINT)
            .minCols(DEFAULT_MIN_COLS)
            .maxCols(DEFAULT_MAX_COLS)
            .minRows(DEFAULT_MIN_ROWS)
            .maxRows(DEFAULT_MAX_ROWS)
            .maxItemCols(DEFAULT_MAX_ITEM_COLS)
            .minItemCols(DEFAULT_MIN_ITEM_COLS)
            .maxItemRows(DEFAULT_MAX_ITEM_ROWS)
            .minItemRows(DEFAULT_MIN_ITEM_ROWS)
            .maxItemArea(DEFAULT_MAX_ITEM_AREA)
            .minItemArea(DEFAULT_MIN_ITEM_AREA)
            .defaultItemCols(DEFAULT_DEFAULT_ITEM_COLS)
            .defaultItemRows(DEFAULT_DEFAULT_ITEM_ROWS)
            .ignoreMarginInRow(DEFAULT_IGNORE_MARGIN_IN_ROW)
            .draggable(DEFAULT_DRAGGABLE)
            .resizable(DEFAULT_RESIZABLE);
        return dashboardConfig;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DashboardConfig createUpdatedEntity() {
        DashboardConfig dashboardConfig = new DashboardConfig()
            .margin(UPDATED_MARGIN)
            .outerMargin(UPDATED_OUTER_MARGIN)
            .outerMarginTop(UPDATED_OUTER_MARGIN_TOP)
            .useTransformPositioning(UPDATED_USE_TRANSFORM_POSITIONING)
            .mobileBreakpoint(UPDATED_MOBILE_BREAKPOINT)
            .useBodyForBreakpoint(UPDATED_USE_BODY_FOR_BREAKPOINT)
            .minCols(UPDATED_MIN_COLS)
            .maxCols(UPDATED_MAX_COLS)
            .minRows(UPDATED_MIN_ROWS)
            .maxRows(UPDATED_MAX_ROWS)
            .maxItemCols(UPDATED_MAX_ITEM_COLS)
            .minItemCols(UPDATED_MIN_ITEM_COLS)
            .maxItemRows(UPDATED_MAX_ITEM_ROWS)
            .minItemRows(UPDATED_MIN_ITEM_ROWS)
            .maxItemArea(UPDATED_MAX_ITEM_AREA)
            .minItemArea(UPDATED_MIN_ITEM_AREA)
            .defaultItemCols(UPDATED_DEFAULT_ITEM_COLS)
            .defaultItemRows(UPDATED_DEFAULT_ITEM_ROWS)
            .ignoreMarginInRow(UPDATED_IGNORE_MARGIN_IN_ROW)
            .draggable(UPDATED_DRAGGABLE)
            .resizable(UPDATED_RESIZABLE);
        return dashboardConfig;
    }

    @BeforeEach
    public void initTest() {
        dashboardConfigRepository.deleteAll();
        dashboardConfig = createEntity();
    }

    @Test
    void createDashboardConfig() throws Exception {
        int databaseSizeBeforeCreate = dashboardConfigRepository.findAll().size();
        // Create the DashboardConfig
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);
        restDashboardConfigMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isCreated());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeCreate + 1);
        DashboardConfig testDashboardConfig = dashboardConfigList.get(dashboardConfigList.size() - 1);
        assertThat(testDashboardConfig.getMargin()).isEqualTo(DEFAULT_MARGIN);
        assertThat(testDashboardConfig.getOuterMargin()).isEqualTo(DEFAULT_OUTER_MARGIN);
        assertThat(testDashboardConfig.getOuterMarginTop()).isEqualTo(DEFAULT_OUTER_MARGIN_TOP);
        assertThat(testDashboardConfig.getUseTransformPositioning()).isEqualTo(DEFAULT_USE_TRANSFORM_POSITIONING);
        assertThat(testDashboardConfig.getMobileBreakpoint()).isEqualTo(DEFAULT_MOBILE_BREAKPOINT);
        assertThat(testDashboardConfig.getUseBodyForBreakpoint()).isEqualTo(DEFAULT_USE_BODY_FOR_BREAKPOINT);
        assertThat(testDashboardConfig.getMinCols()).isEqualTo(DEFAULT_MIN_COLS);
        assertThat(testDashboardConfig.getMaxCols()).isEqualTo(DEFAULT_MAX_COLS);
        assertThat(testDashboardConfig.getMinRows()).isEqualTo(DEFAULT_MIN_ROWS);
        assertThat(testDashboardConfig.getMaxRows()).isEqualTo(DEFAULT_MAX_ROWS);
        assertThat(testDashboardConfig.getMaxItemCols()).isEqualTo(DEFAULT_MAX_ITEM_COLS);
        assertThat(testDashboardConfig.getMinItemCols()).isEqualTo(DEFAULT_MIN_ITEM_COLS);
        assertThat(testDashboardConfig.getMaxItemRows()).isEqualTo(DEFAULT_MAX_ITEM_ROWS);
        assertThat(testDashboardConfig.getMinItemRows()).isEqualTo(DEFAULT_MIN_ITEM_ROWS);
        assertThat(testDashboardConfig.getMaxItemArea()).isEqualTo(DEFAULT_MAX_ITEM_AREA);
        assertThat(testDashboardConfig.getMinItemArea()).isEqualTo(DEFAULT_MIN_ITEM_AREA);
        assertThat(testDashboardConfig.getDefaultItemCols()).isEqualTo(DEFAULT_DEFAULT_ITEM_COLS);
        assertThat(testDashboardConfig.getDefaultItemRows()).isEqualTo(DEFAULT_DEFAULT_ITEM_ROWS);
        assertThat(testDashboardConfig.getIgnoreMarginInRow()).isEqualTo(DEFAULT_IGNORE_MARGIN_IN_ROW);
        assertThat(testDashboardConfig.getDraggable()).isEqualTo(DEFAULT_DRAGGABLE);
        assertThat(testDashboardConfig.getResizable()).isEqualTo(DEFAULT_RESIZABLE);
    }

    @Test
    void createDashboardConfigWithExistingId() throws Exception {
        // Create the DashboardConfig with an existing ID
        dashboardConfig.setId("existing_id");
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);

        int databaseSizeBeforeCreate = dashboardConfigRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restDashboardConfigMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    void getAllDashboardConfigs() throws Exception {
        // Initialize the database
        dashboardConfig.setId(UUID.randomUUID().toString());
        dashboardConfigRepository.save(dashboardConfig);

        // Get all the dashboardConfigList
        restDashboardConfigMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(dashboardConfig.getId())))
            .andExpect(jsonPath("$.[*].margin").value(hasItem(DEFAULT_MARGIN)))
            .andExpect(jsonPath("$.[*].outerMargin").value(hasItem(DEFAULT_OUTER_MARGIN.booleanValue())))
            .andExpect(jsonPath("$.[*].outerMarginTop").value(hasItem(DEFAULT_OUTER_MARGIN_TOP)))
            .andExpect(jsonPath("$.[*].useTransformPositioning").value(hasItem(DEFAULT_USE_TRANSFORM_POSITIONING.booleanValue())))
            .andExpect(jsonPath("$.[*].mobileBreakpoint").value(hasItem(DEFAULT_MOBILE_BREAKPOINT)))
            .andExpect(jsonPath("$.[*].useBodyForBreakpoint").value(hasItem(DEFAULT_USE_BODY_FOR_BREAKPOINT.booleanValue())))
            .andExpect(jsonPath("$.[*].minCols").value(hasItem(DEFAULT_MIN_COLS)))
            .andExpect(jsonPath("$.[*].maxCols").value(hasItem(DEFAULT_MAX_COLS)))
            .andExpect(jsonPath("$.[*].minRows").value(hasItem(DEFAULT_MIN_ROWS)))
            .andExpect(jsonPath("$.[*].maxRows").value(hasItem(DEFAULT_MAX_ROWS)))
            .andExpect(jsonPath("$.[*].maxItemCols").value(hasItem(DEFAULT_MAX_ITEM_COLS)))
            .andExpect(jsonPath("$.[*].minItemCols").value(hasItem(DEFAULT_MIN_ITEM_COLS)))
            .andExpect(jsonPath("$.[*].maxItemRows").value(hasItem(DEFAULT_MAX_ITEM_ROWS)))
            .andExpect(jsonPath("$.[*].minItemRows").value(hasItem(DEFAULT_MIN_ITEM_ROWS)))
            .andExpect(jsonPath("$.[*].maxItemArea").value(hasItem(DEFAULT_MAX_ITEM_AREA)))
            .andExpect(jsonPath("$.[*].minItemArea").value(hasItem(DEFAULT_MIN_ITEM_AREA)))
            .andExpect(jsonPath("$.[*].defaultItemCols").value(hasItem(DEFAULT_DEFAULT_ITEM_COLS)))
            .andExpect(jsonPath("$.[*].defaultItemRows").value(hasItem(DEFAULT_DEFAULT_ITEM_ROWS)))
            .andExpect(jsonPath("$.[*].ignoreMarginInRow").value(hasItem(DEFAULT_IGNORE_MARGIN_IN_ROW.booleanValue())))
            .andExpect(jsonPath("$.[*].draggable").value(hasItem(DEFAULT_DRAGGABLE.booleanValue())))
            .andExpect(jsonPath("$.[*].resizable").value(hasItem(DEFAULT_RESIZABLE.booleanValue())));
    }

    @Test
    void getDashboardConfig() throws Exception {
        // Initialize the database
        dashboardConfig.setId(UUID.randomUUID().toString());
        dashboardConfigRepository.save(dashboardConfig);

        // Get the dashboardConfig
        restDashboardConfigMockMvc
            .perform(get(ENTITY_API_URL_ID, dashboardConfig.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(dashboardConfig.getId()))
            .andExpect(jsonPath("$.margin").value(DEFAULT_MARGIN))
            .andExpect(jsonPath("$.outerMargin").value(DEFAULT_OUTER_MARGIN.booleanValue()))
            .andExpect(jsonPath("$.outerMarginTop").value(DEFAULT_OUTER_MARGIN_TOP))
            .andExpect(jsonPath("$.useTransformPositioning").value(DEFAULT_USE_TRANSFORM_POSITIONING.booleanValue()))
            .andExpect(jsonPath("$.mobileBreakpoint").value(DEFAULT_MOBILE_BREAKPOINT))
            .andExpect(jsonPath("$.useBodyForBreakpoint").value(DEFAULT_USE_BODY_FOR_BREAKPOINT.booleanValue()))
            .andExpect(jsonPath("$.minCols").value(DEFAULT_MIN_COLS))
            .andExpect(jsonPath("$.maxCols").value(DEFAULT_MAX_COLS))
            .andExpect(jsonPath("$.minRows").value(DEFAULT_MIN_ROWS))
            .andExpect(jsonPath("$.maxRows").value(DEFAULT_MAX_ROWS))
            .andExpect(jsonPath("$.maxItemCols").value(DEFAULT_MAX_ITEM_COLS))
            .andExpect(jsonPath("$.minItemCols").value(DEFAULT_MIN_ITEM_COLS))
            .andExpect(jsonPath("$.maxItemRows").value(DEFAULT_MAX_ITEM_ROWS))
            .andExpect(jsonPath("$.minItemRows").value(DEFAULT_MIN_ITEM_ROWS))
            .andExpect(jsonPath("$.maxItemArea").value(DEFAULT_MAX_ITEM_AREA))
            .andExpect(jsonPath("$.minItemArea").value(DEFAULT_MIN_ITEM_AREA))
            .andExpect(jsonPath("$.defaultItemCols").value(DEFAULT_DEFAULT_ITEM_COLS))
            .andExpect(jsonPath("$.defaultItemRows").value(DEFAULT_DEFAULT_ITEM_ROWS))
            .andExpect(jsonPath("$.ignoreMarginInRow").value(DEFAULT_IGNORE_MARGIN_IN_ROW.booleanValue()))
            .andExpect(jsonPath("$.draggable").value(DEFAULT_DRAGGABLE.booleanValue()))
            .andExpect(jsonPath("$.resizable").value(DEFAULT_RESIZABLE.booleanValue()));
    }

    @Test
    void getNonExistingDashboardConfig() throws Exception {
        // Get the dashboardConfig
        restDashboardConfigMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    void putNewDashboardConfig() throws Exception {
        // Initialize the database
        dashboardConfig.setId(UUID.randomUUID().toString());
        dashboardConfigRepository.save(dashboardConfig);

        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();

        // Update the dashboardConfig
        DashboardConfig updatedDashboardConfig = dashboardConfigRepository.findById(dashboardConfig.getId()).get();
        updatedDashboardConfig
            .margin(UPDATED_MARGIN)
            .outerMargin(UPDATED_OUTER_MARGIN)
            .outerMarginTop(UPDATED_OUTER_MARGIN_TOP)
            .useTransformPositioning(UPDATED_USE_TRANSFORM_POSITIONING)
            .mobileBreakpoint(UPDATED_MOBILE_BREAKPOINT)
            .useBodyForBreakpoint(UPDATED_USE_BODY_FOR_BREAKPOINT)
            .minCols(UPDATED_MIN_COLS)
            .maxCols(UPDATED_MAX_COLS)
            .minRows(UPDATED_MIN_ROWS)
            .maxRows(UPDATED_MAX_ROWS)
            .maxItemCols(UPDATED_MAX_ITEM_COLS)
            .minItemCols(UPDATED_MIN_ITEM_COLS)
            .maxItemRows(UPDATED_MAX_ITEM_ROWS)
            .minItemRows(UPDATED_MIN_ITEM_ROWS)
            .maxItemArea(UPDATED_MAX_ITEM_AREA)
            .minItemArea(UPDATED_MIN_ITEM_AREA)
            .defaultItemCols(UPDATED_DEFAULT_ITEM_COLS)
            .defaultItemRows(UPDATED_DEFAULT_ITEM_ROWS)
            .ignoreMarginInRow(UPDATED_IGNORE_MARGIN_IN_ROW)
            .draggable(UPDATED_DRAGGABLE)
            .resizable(UPDATED_RESIZABLE);
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(updatedDashboardConfig);

        restDashboardConfigMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dashboardConfigDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isOk());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
        DashboardConfig testDashboardConfig = dashboardConfigList.get(dashboardConfigList.size() - 1);
        assertThat(testDashboardConfig.getMargin()).isEqualTo(UPDATED_MARGIN);
        assertThat(testDashboardConfig.getOuterMargin()).isEqualTo(UPDATED_OUTER_MARGIN);
        assertThat(testDashboardConfig.getOuterMarginTop()).isEqualTo(UPDATED_OUTER_MARGIN_TOP);
        assertThat(testDashboardConfig.getUseTransformPositioning()).isEqualTo(UPDATED_USE_TRANSFORM_POSITIONING);
        assertThat(testDashboardConfig.getMobileBreakpoint()).isEqualTo(UPDATED_MOBILE_BREAKPOINT);
        assertThat(testDashboardConfig.getUseBodyForBreakpoint()).isEqualTo(UPDATED_USE_BODY_FOR_BREAKPOINT);
        assertThat(testDashboardConfig.getMinCols()).isEqualTo(UPDATED_MIN_COLS);
        assertThat(testDashboardConfig.getMaxCols()).isEqualTo(UPDATED_MAX_COLS);
        assertThat(testDashboardConfig.getMinRows()).isEqualTo(UPDATED_MIN_ROWS);
        assertThat(testDashboardConfig.getMaxRows()).isEqualTo(UPDATED_MAX_ROWS);
        assertThat(testDashboardConfig.getMaxItemCols()).isEqualTo(UPDATED_MAX_ITEM_COLS);
        assertThat(testDashboardConfig.getMinItemCols()).isEqualTo(UPDATED_MIN_ITEM_COLS);
        assertThat(testDashboardConfig.getMaxItemRows()).isEqualTo(UPDATED_MAX_ITEM_ROWS);
        assertThat(testDashboardConfig.getMinItemRows()).isEqualTo(UPDATED_MIN_ITEM_ROWS);
        assertThat(testDashboardConfig.getMaxItemArea()).isEqualTo(UPDATED_MAX_ITEM_AREA);
        assertThat(testDashboardConfig.getMinItemArea()).isEqualTo(UPDATED_MIN_ITEM_AREA);
        assertThat(testDashboardConfig.getDefaultItemCols()).isEqualTo(UPDATED_DEFAULT_ITEM_COLS);
        assertThat(testDashboardConfig.getDefaultItemRows()).isEqualTo(UPDATED_DEFAULT_ITEM_ROWS);
        assertThat(testDashboardConfig.getIgnoreMarginInRow()).isEqualTo(UPDATED_IGNORE_MARGIN_IN_ROW);
        assertThat(testDashboardConfig.getDraggable()).isEqualTo(UPDATED_DRAGGABLE);
        assertThat(testDashboardConfig.getResizable()).isEqualTo(UPDATED_RESIZABLE);
    }

    @Test
    void putNonExistingDashboardConfig() throws Exception {
        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();
        dashboardConfig.setId(UUID.randomUUID().toString());

        // Create the DashboardConfig
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDashboardConfigMockMvc
            .perform(
                put(ENTITY_API_URL_ID, dashboardConfigDTO.getId())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchDashboardConfig() throws Exception {
        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();
        dashboardConfig.setId(UUID.randomUUID().toString());

        // Create the DashboardConfig
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDashboardConfigMockMvc
            .perform(
                put(ENTITY_API_URL_ID, UUID.randomUUID().toString())
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamDashboardConfig() throws Exception {
        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();
        dashboardConfig.setId(UUID.randomUUID().toString());

        // Create the DashboardConfig
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDashboardConfigMockMvc
            .perform(
                put(ENTITY_API_URL)
                    .with(csrf())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateDashboardConfigWithPatch() throws Exception {
        // Initialize the database
        dashboardConfig.setId(UUID.randomUUID().toString());
        dashboardConfigRepository.save(dashboardConfig);

        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();

        // Update the dashboardConfig using partial update
        DashboardConfig partialUpdatedDashboardConfig = new DashboardConfig();
        partialUpdatedDashboardConfig.setId(dashboardConfig.getId());

        partialUpdatedDashboardConfig
            .margin(UPDATED_MARGIN)
            .outerMargin(UPDATED_OUTER_MARGIN)
            .useTransformPositioning(UPDATED_USE_TRANSFORM_POSITIONING)
            .mobileBreakpoint(UPDATED_MOBILE_BREAKPOINT)
            .minCols(UPDATED_MIN_COLS)
            .maxCols(UPDATED_MAX_COLS)
            .minRows(UPDATED_MIN_ROWS)
            .minItemCols(UPDATED_MIN_ITEM_COLS)
            .maxItemArea(UPDATED_MAX_ITEM_AREA)
            .minItemArea(UPDATED_MIN_ITEM_AREA)
            .defaultItemRows(UPDATED_DEFAULT_ITEM_ROWS)
            .draggable(UPDATED_DRAGGABLE)
            .resizable(UPDATED_RESIZABLE);

        restDashboardConfigMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDashboardConfig.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDashboardConfig))
            )
            .andExpect(status().isOk());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
        DashboardConfig testDashboardConfig = dashboardConfigList.get(dashboardConfigList.size() - 1);
        assertThat(testDashboardConfig.getMargin()).isEqualTo(UPDATED_MARGIN);
        assertThat(testDashboardConfig.getOuterMargin()).isEqualTo(UPDATED_OUTER_MARGIN);
        assertThat(testDashboardConfig.getOuterMarginTop()).isEqualTo(DEFAULT_OUTER_MARGIN_TOP);
        assertThat(testDashboardConfig.getUseTransformPositioning()).isEqualTo(UPDATED_USE_TRANSFORM_POSITIONING);
        assertThat(testDashboardConfig.getMobileBreakpoint()).isEqualTo(UPDATED_MOBILE_BREAKPOINT);
        assertThat(testDashboardConfig.getUseBodyForBreakpoint()).isEqualTo(DEFAULT_USE_BODY_FOR_BREAKPOINT);
        assertThat(testDashboardConfig.getMinCols()).isEqualTo(UPDATED_MIN_COLS);
        assertThat(testDashboardConfig.getMaxCols()).isEqualTo(UPDATED_MAX_COLS);
        assertThat(testDashboardConfig.getMinRows()).isEqualTo(UPDATED_MIN_ROWS);
        assertThat(testDashboardConfig.getMaxRows()).isEqualTo(DEFAULT_MAX_ROWS);
        assertThat(testDashboardConfig.getMaxItemCols()).isEqualTo(DEFAULT_MAX_ITEM_COLS);
        assertThat(testDashboardConfig.getMinItemCols()).isEqualTo(UPDATED_MIN_ITEM_COLS);
        assertThat(testDashboardConfig.getMaxItemRows()).isEqualTo(DEFAULT_MAX_ITEM_ROWS);
        assertThat(testDashboardConfig.getMinItemRows()).isEqualTo(DEFAULT_MIN_ITEM_ROWS);
        assertThat(testDashboardConfig.getMaxItemArea()).isEqualTo(UPDATED_MAX_ITEM_AREA);
        assertThat(testDashboardConfig.getMinItemArea()).isEqualTo(UPDATED_MIN_ITEM_AREA);
        assertThat(testDashboardConfig.getDefaultItemCols()).isEqualTo(DEFAULT_DEFAULT_ITEM_COLS);
        assertThat(testDashboardConfig.getDefaultItemRows()).isEqualTo(UPDATED_DEFAULT_ITEM_ROWS);
        assertThat(testDashboardConfig.getIgnoreMarginInRow()).isEqualTo(DEFAULT_IGNORE_MARGIN_IN_ROW);
        assertThat(testDashboardConfig.getDraggable()).isEqualTo(UPDATED_DRAGGABLE);
        assertThat(testDashboardConfig.getResizable()).isEqualTo(UPDATED_RESIZABLE);
    }

    @Test
    void fullUpdateDashboardConfigWithPatch() throws Exception {
        // Initialize the database
        dashboardConfig.setId(UUID.randomUUID().toString());
        dashboardConfigRepository.save(dashboardConfig);

        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();

        // Update the dashboardConfig using partial update
        DashboardConfig partialUpdatedDashboardConfig = new DashboardConfig();
        partialUpdatedDashboardConfig.setId(dashboardConfig.getId());

        partialUpdatedDashboardConfig
            .margin(UPDATED_MARGIN)
            .outerMargin(UPDATED_OUTER_MARGIN)
            .outerMarginTop(UPDATED_OUTER_MARGIN_TOP)
            .useTransformPositioning(UPDATED_USE_TRANSFORM_POSITIONING)
            .mobileBreakpoint(UPDATED_MOBILE_BREAKPOINT)
            .useBodyForBreakpoint(UPDATED_USE_BODY_FOR_BREAKPOINT)
            .minCols(UPDATED_MIN_COLS)
            .maxCols(UPDATED_MAX_COLS)
            .minRows(UPDATED_MIN_ROWS)
            .maxRows(UPDATED_MAX_ROWS)
            .maxItemCols(UPDATED_MAX_ITEM_COLS)
            .minItemCols(UPDATED_MIN_ITEM_COLS)
            .maxItemRows(UPDATED_MAX_ITEM_ROWS)
            .minItemRows(UPDATED_MIN_ITEM_ROWS)
            .maxItemArea(UPDATED_MAX_ITEM_AREA)
            .minItemArea(UPDATED_MIN_ITEM_AREA)
            .defaultItemCols(UPDATED_DEFAULT_ITEM_COLS)
            .defaultItemRows(UPDATED_DEFAULT_ITEM_ROWS)
            .ignoreMarginInRow(UPDATED_IGNORE_MARGIN_IN_ROW)
            .draggable(UPDATED_DRAGGABLE)
            .resizable(UPDATED_RESIZABLE);

        restDashboardConfigMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedDashboardConfig.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedDashboardConfig))
            )
            .andExpect(status().isOk());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
        DashboardConfig testDashboardConfig = dashboardConfigList.get(dashboardConfigList.size() - 1);
        assertThat(testDashboardConfig.getMargin()).isEqualTo(UPDATED_MARGIN);
        assertThat(testDashboardConfig.getOuterMargin()).isEqualTo(UPDATED_OUTER_MARGIN);
        assertThat(testDashboardConfig.getOuterMarginTop()).isEqualTo(UPDATED_OUTER_MARGIN_TOP);
        assertThat(testDashboardConfig.getUseTransformPositioning()).isEqualTo(UPDATED_USE_TRANSFORM_POSITIONING);
        assertThat(testDashboardConfig.getMobileBreakpoint()).isEqualTo(UPDATED_MOBILE_BREAKPOINT);
        assertThat(testDashboardConfig.getUseBodyForBreakpoint()).isEqualTo(UPDATED_USE_BODY_FOR_BREAKPOINT);
        assertThat(testDashboardConfig.getMinCols()).isEqualTo(UPDATED_MIN_COLS);
        assertThat(testDashboardConfig.getMaxCols()).isEqualTo(UPDATED_MAX_COLS);
        assertThat(testDashboardConfig.getMinRows()).isEqualTo(UPDATED_MIN_ROWS);
        assertThat(testDashboardConfig.getMaxRows()).isEqualTo(UPDATED_MAX_ROWS);
        assertThat(testDashboardConfig.getMaxItemCols()).isEqualTo(UPDATED_MAX_ITEM_COLS);
        assertThat(testDashboardConfig.getMinItemCols()).isEqualTo(UPDATED_MIN_ITEM_COLS);
        assertThat(testDashboardConfig.getMaxItemRows()).isEqualTo(UPDATED_MAX_ITEM_ROWS);
        assertThat(testDashboardConfig.getMinItemRows()).isEqualTo(UPDATED_MIN_ITEM_ROWS);
        assertThat(testDashboardConfig.getMaxItemArea()).isEqualTo(UPDATED_MAX_ITEM_AREA);
        assertThat(testDashboardConfig.getMinItemArea()).isEqualTo(UPDATED_MIN_ITEM_AREA);
        assertThat(testDashboardConfig.getDefaultItemCols()).isEqualTo(UPDATED_DEFAULT_ITEM_COLS);
        assertThat(testDashboardConfig.getDefaultItemRows()).isEqualTo(UPDATED_DEFAULT_ITEM_ROWS);
        assertThat(testDashboardConfig.getIgnoreMarginInRow()).isEqualTo(UPDATED_IGNORE_MARGIN_IN_ROW);
        assertThat(testDashboardConfig.getDraggable()).isEqualTo(UPDATED_DRAGGABLE);
        assertThat(testDashboardConfig.getResizable()).isEqualTo(UPDATED_RESIZABLE);
    }

    @Test
    void patchNonExistingDashboardConfig() throws Exception {
        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();
        dashboardConfig.setId(UUID.randomUUID().toString());

        // Create the DashboardConfig
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restDashboardConfigMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, dashboardConfigDTO.getId())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchDashboardConfig() throws Exception {
        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();
        dashboardConfig.setId(UUID.randomUUID().toString());

        // Create the DashboardConfig
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDashboardConfigMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, UUID.randomUUID().toString())
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamDashboardConfig() throws Exception {
        int databaseSizeBeforeUpdate = dashboardConfigRepository.findAll().size();
        dashboardConfig.setId(UUID.randomUUID().toString());

        // Create the DashboardConfig
        DashboardConfigDTO dashboardConfigDTO = dashboardConfigMapper.toDto(dashboardConfig);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restDashboardConfigMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .with(csrf())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(dashboardConfigDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the DashboardConfig in the database
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteDashboardConfig() throws Exception {
        // Initialize the database
        dashboardConfig.setId(UUID.randomUUID().toString());
        dashboardConfigRepository.save(dashboardConfig);

        int databaseSizeBeforeDelete = dashboardConfigRepository.findAll().size();

        // Delete the dashboardConfig
        restDashboardConfigMockMvc
            .perform(delete(ENTITY_API_URL_ID, dashboardConfig.getId()).with(csrf()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<DashboardConfig> dashboardConfigList = dashboardConfigRepository.findAll();
        assertThat(dashboardConfigList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
