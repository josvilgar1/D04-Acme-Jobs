
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

    request.unbind(entity, model, "countAnnouncement", "countCompanyRecords", "countInvestorRecords");
		request.unbind(entity, model, "minActiveRequest", "maxActiveRequest", "avgActiveRequest", "stDerivationActiveRequest");
		request.unbind(entity, model, "minRangeMinActiveOffer", "maxRangeMinActiveOffer", "avgRangeMinActiveOffer", "stDerivationRangeMinActiveOffer");
		request.unbind(entity, model, "minRangeMaxActiveOffer", "maxRangeMaxActiveOffer", "avgRangeMaxActiveOffer", "stDerivationRangeMaxActiveOffer");
		request.unbind(entity, model, "numSectorbyCompany", "sectorsbyCompany", "numSectorbyInvestor", "sectorsbyInvestor");
		request.unbind(entity, model, "avgJobPerEmployer", "avgApplicationPerEmployer", "avgApplicationPerWorker");
		request.unbind(entity, model, "ratioJobsGroupedStatusPublished", "ratioJobsGroupedStatusDraft", "ratioApplicationsGroupedStatusPending");
		request.unbind(entity, model, "ratioApplicationsGroupedStatusAccepted", "ratioApplicationsGroupedStatusRejected");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		result.setCountAnnouncement(this.repository.countAnnouncement());
		result.setCountCompanyRecords(this.repository.countCompanyRecord());
		result.setCountInvestorRecords(this.repository.countInvestorRecords());

		result.setMinActiveRequest(this.repository.queryActiveRequest(new Date())[0][0]);
		result.setMaxActiveRequest(this.repository.queryActiveRequest(new Date())[0][1]);
		result.setAvgActiveRequest(this.repository.queryActiveRequest(new Date())[0][2]);
		result.setStDerivationActiveRequest(this.repository.queryActiveRequest(new Date())[0][3]);

		result.setMinRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][0]);
		result.setMaxRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][1]);
		result.setAvgRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][2]);
		result.setStDerivationRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][3]);

		result.setMinRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][0]);
		result.setMaxRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][1]);
		result.setAvgRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][2]);
		result.setStDerivationRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][3]);

		result.setAvgJobPerEmployer(this.repository.queryAVGJobPerEmployer());
		result.setAvgApplicationPerEmployer(this.repository.queryAVGApplicationPerEmployer());
		result.setAvgApplicationPerWorker(this.repository.queryAVGApplicationPerWorker());

		Object[] sectorescompany = this.repository.sectorspercompany();

		List<Integer> nc = new ArrayList<Integer>();
		List<String> sc = new ArrayList<String>();

		int ic = 0;
		while (ic < sectorescompany.length) {
			Object[] x = (Object[]) sectorescompany[ic];
			nc.add(Integer.parseInt(x[1].toString()));
			sc.add(x[0].toString());
			ic++;
		}

		result.setNumSectorbyCompany(nc);
		result.setSectorsbyCompany(sc);

		Object[] sectoresinvestor = this.repository.sectorsperinvestor();

		List<Integer> ni = new ArrayList<Integer>();
		List<String> si = new ArrayList<String>();

		int ii = 0;
		while (ii < sectoresinvestor.length) {
			Object[] x = (Object[]) sectoresinvestor[ii];
			ni.add(Integer.parseInt(x[1].toString()));
			si.add(x[0].toString());
			ii++;
		}

		result.setNumSectorbyInvestor(ni);
		result.setSectorsbyInvestor(si);

		result.setRatioJobsGroupedStatusPublished(this.repository.ratioJobsGroupedStatusPublished());
		result.setRatioJobsGroupedStatusDraft(this.repository.ratioJobsGroupedStatusDraft());

		result.setRatioApplicationsGroupedStatusPending(this.repository.ratioApplicationsGroupedStatusPending());
		result.setRatioApplicationsGroupedStatusAccepted(this.repository.ratioApplicationsGroupedStatusAccepted());
		result.setRatioApplicationsGroupedStatusRejected(this.repository.ratioApplicationsGroupedStatusRejected());

		return result;
	}
}
