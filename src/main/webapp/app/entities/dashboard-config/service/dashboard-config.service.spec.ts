import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { IDashboardConfig, DashboardConfig } from '../dashboard-config.model';

import { DashboardConfigService } from './dashboard-config.service';

describe('DashboardConfig Service', () => {
  let service: DashboardConfigService;
  let httpMock: HttpTestingController;
  let elemDefault: IDashboardConfig;
  let expectedResult: IDashboardConfig | IDashboardConfig[] | boolean | null;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
    });
    expectedResult = null;
    service = TestBed.inject(DashboardConfigService);
    httpMock = TestBed.inject(HttpTestingController);

    elemDefault = {
      id: 'AAAAAAA',
      margin: 0,
      outerMargin: false,
      outerMarginTop: 0,
      useTransformPositioning: false,
      mobileBreakpoint: 0,
      useBodyForBreakpoint: false,
      minCols: 0,
      maxCols: 0,
      minRows: 0,
      maxRows: 0,
      maxItemCols: 0,
      minItemCols: 0,
      maxItemRows: 0,
      minItemRows: 0,
      maxItemArea: 0,
      minItemArea: 0,
      defaultItemCols: 0,
      defaultItemRows: 0,
      ignoreMarginInRow: false,
      draggable: false,
      resizable: false,
    };
  });

  describe('Service methods', () => {
    it('should find an element', () => {
      const returnedFromService = Object.assign({}, elemDefault);

      service.find('ABC').subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(elemDefault);
    });

    it('should create a DashboardConfig', () => {
      const returnedFromService = Object.assign(
        {
          id: 'ID',
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.create(new DashboardConfig()).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'POST' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should update a DashboardConfig', () => {
      const returnedFromService = Object.assign(
        {
          id: 'BBBBBB',
          margin: 1,
          outerMargin: true,
          outerMarginTop: 1,
          useTransformPositioning: true,
          mobileBreakpoint: 1,
          useBodyForBreakpoint: true,
          minCols: 1,
          maxCols: 1,
          minRows: 1,
          maxRows: 1,
          maxItemCols: 1,
          minItemCols: 1,
          maxItemRows: 1,
          minItemRows: 1,
          maxItemArea: 1,
          minItemArea: 1,
          defaultItemCols: 1,
          defaultItemRows: 1,
          ignoreMarginInRow: true,
          draggable: true,
          resizable: true,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.update(expected).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PUT' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should partial update a DashboardConfig', () => {
      const patchObject = Object.assign(
        {
          outerMarginTop: 1,
          minCols: 1,
          maxCols: 1,
          maxRows: 1,
          minItemRows: 1,
          maxItemArea: 1,
          minItemArea: 1,
          defaultItemCols: 1,
          defaultItemRows: 1,
          ignoreMarginInRow: true,
          draggable: true,
        },
        new DashboardConfig()
      );

      const returnedFromService = Object.assign(patchObject, elemDefault);

      const expected = Object.assign({}, returnedFromService);

      service.partialUpdate(patchObject).subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'PATCH' });
      req.flush(returnedFromService);
      expect(expectedResult).toMatchObject(expected);
    });

    it('should return a list of DashboardConfig', () => {
      const returnedFromService = Object.assign(
        {
          id: 'BBBBBB',
          margin: 1,
          outerMargin: true,
          outerMarginTop: 1,
          useTransformPositioning: true,
          mobileBreakpoint: 1,
          useBodyForBreakpoint: true,
          minCols: 1,
          maxCols: 1,
          minRows: 1,
          maxRows: 1,
          maxItemCols: 1,
          minItemCols: 1,
          maxItemRows: 1,
          minItemRows: 1,
          maxItemArea: 1,
          minItemArea: 1,
          defaultItemCols: 1,
          defaultItemRows: 1,
          ignoreMarginInRow: true,
          draggable: true,
          resizable: true,
        },
        elemDefault
      );

      const expected = Object.assign({}, returnedFromService);

      service.query().subscribe(resp => (expectedResult = resp.body));

      const req = httpMock.expectOne({ method: 'GET' });
      req.flush([returnedFromService]);
      httpMock.verify();
      expect(expectedResult).toContainEqual(expected);
    });

    it('should delete a DashboardConfig', () => {
      service.delete('ABC').subscribe(resp => (expectedResult = resp.ok));

      const req = httpMock.expectOne({ method: 'DELETE' });
      req.flush({ status: 200 });
      expect(expectedResult);
    });

    describe('addDashboardConfigToCollectionIfMissing', () => {
      it('should add a DashboardConfig to an empty array', () => {
        const dashboardConfig: IDashboardConfig = { id: 'ABC' };
        expectedResult = service.addDashboardConfigToCollectionIfMissing([], dashboardConfig);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dashboardConfig);
      });

      it('should not add a DashboardConfig to an array that contains it', () => {
        const dashboardConfig: IDashboardConfig = { id: 'ABC' };
        const dashboardConfigCollection: IDashboardConfig[] = [
          {
            ...dashboardConfig,
          },
          { id: 'CBA' },
        ];
        expectedResult = service.addDashboardConfigToCollectionIfMissing(dashboardConfigCollection, dashboardConfig);
        expect(expectedResult).toHaveLength(2);
      });

      it("should add a DashboardConfig to an array that doesn't contain it", () => {
        const dashboardConfig: IDashboardConfig = { id: 'ABC' };
        const dashboardConfigCollection: IDashboardConfig[] = [{ id: 'CBA' }];
        expectedResult = service.addDashboardConfigToCollectionIfMissing(dashboardConfigCollection, dashboardConfig);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dashboardConfig);
      });

      it('should add only unique DashboardConfig to an array', () => {
        const dashboardConfigArray: IDashboardConfig[] = [{ id: 'ABC' }, { id: 'CBA' }, { id: '624094f5-2f75-4db6-a8a4-7dbc73460c5c' }];
        const dashboardConfigCollection: IDashboardConfig[] = [{ id: 'ABC' }];
        expectedResult = service.addDashboardConfigToCollectionIfMissing(dashboardConfigCollection, ...dashboardConfigArray);
        expect(expectedResult).toHaveLength(3);
      });

      it('should accept varargs', () => {
        const dashboardConfig: IDashboardConfig = { id: 'ABC' };
        const dashboardConfig2: IDashboardConfig = { id: 'CBA' };
        expectedResult = service.addDashboardConfigToCollectionIfMissing([], dashboardConfig, dashboardConfig2);
        expect(expectedResult).toHaveLength(2);
        expect(expectedResult).toContain(dashboardConfig);
        expect(expectedResult).toContain(dashboardConfig2);
      });

      it('should accept null and undefined values', () => {
        const dashboardConfig: IDashboardConfig = { id: 'ABC' };
        expectedResult = service.addDashboardConfigToCollectionIfMissing([], null, dashboardConfig, undefined);
        expect(expectedResult).toHaveLength(1);
        expect(expectedResult).toContain(dashboardConfig);
      });

      it('should return initial array if no DashboardConfig is added', () => {
        const dashboardConfigCollection: IDashboardConfig[] = [{ id: 'ABC' }];
        expectedResult = service.addDashboardConfigToCollectionIfMissing(dashboardConfigCollection, undefined, null);
        expect(expectedResult).toEqual(dashboardConfigCollection);
      });
    });
  });

  afterEach(() => {
    httpMock.verify();
  });
});
