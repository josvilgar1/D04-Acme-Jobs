
package acme.features.auditor.auditorrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditrecords.Auditrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditrecordRepository extends AbstractRepository {

	@Query("select j from Auditrecord j where j.id = ?1")
	Auditrecord findOneById(int id);

	@Query("select j from Auditrecord j where j.job.id = ?1")
	Collection<Auditrecord> findAuditrecordsByJob(Integer id);

}
