
package acme.features.worker.job;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobRepository extends AbstractRepository {

	@Query("select j from Job j where j.id = (select a.job.id from Application a where a.id = ?1)")
	Job findOneByApplicationId(int id);
}
