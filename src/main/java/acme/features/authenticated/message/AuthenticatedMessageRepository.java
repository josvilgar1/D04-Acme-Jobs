
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.messages.Message;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select a from Message a where a.id = ?1")
	Message findOneById(int id);

	@Query("select mt from Message mt where mt.messageThread.id = ?1")
	Collection<Message> findManyByMessagethread(int id);

}
