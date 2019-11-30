
package acme.features.administrator.dashboard;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Integer countAnnouncement();

	@Query("select count(c) from Companyrecord c")
	Integer countCompanyRecord();

	@Query("select count(i) from Investorrecord i")
	Integer countInvestorRecords();

	@Query("select g.sector, count(g) from Companyrecord g group by g.sector")
	Object[] sectorspercompany();

	@Query("select g.sector, count(g) from Investorrecord g group by g.sector")
	Object[] sectorsperinvestor();

	@Query("select min(r.reward.amount),max(r.reward.amount),avg(r.reward.amount),stddev(r.reward.amount) from Request r where r.deadline > ?1")
	Double[][] queryActiveRequest(Date deadline);

	@Query("select min(r.rangeMin.amount),max(r.rangeMin.amount),avg(r.rangeMin.amount),stddev(r.rangeMin.amount) from Offer r where r.deadline > ?1")
	Double[][] queryRangeMinActiveOffer(Date deadline);

	@Query("select min(r.rangeMax.amount),max(r.rangeMax.amount),avg(r.rangeMax.amount),stddev(r.rangeMax.amount) from Offer r where r.deadline > ?1")
	Double[][] queryRangeMaxActiveOffer(Date deadline);

	@Query("select avg(select count(j) from Job j where j.employer.id = e.id) from Employer e")
	Double queryAVGJobPerEmployer();

	@Query("select avg(select count(a) from Application a where a.job.employer.id = e.id) from Employer e")
	Double queryAVGApplicationPerEmployer();

	@Query("select avg(select count(a) from Application a where a.worker.id = w.id) from Worker w")
	Double queryAVGApplicationPerWorker();

}
