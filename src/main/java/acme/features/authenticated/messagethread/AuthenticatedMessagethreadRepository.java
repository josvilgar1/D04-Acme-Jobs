
package acme.features.authenticated.messagethread;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messagethreads.Messagethread;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessagethreadRepository extends AbstractRepository {

	@Query("select a from Messagethread a where a.id = ?1")
	Messagethread findOneById(int id);

	@Query("select a from Messagethread a")
	Collection<Messagethread> findManyMine(int id);

}
