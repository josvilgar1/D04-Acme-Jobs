
package acme.features.administrator.dashboard;

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

	@Query("select min(r.reward.amount),max(r.reward.amount),avg(r.reward.amount),stddev(r.reward.amount) from Request r where r.deadline > current_timestamp()")
	Double[][] queryActiveRequest();

	@Query("select min(r.rangeMin.amount),max(r.rangeMin.amount),avg(r.rangeMin.amount),stddev(r.rangeMin.amount) from Offer r where r.deadline > current_timestamp()")
	Double[][] queryRangeMinActiveOffer();

	@Query("select min(r.rangeMax.amount),max(r.rangeMax.amount),avg(r.rangeMax.amount),stddev(r.rangeMax.amount) from Offer r where r.deadline > current_timestamp()")
	Double[][] queryRangeMaxActiveOffer();

}
