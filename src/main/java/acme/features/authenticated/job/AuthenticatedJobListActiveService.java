
package acme.features.authenticated.job;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedJobListActiveService implements AbstractListService<Authenticated, Job> {

	@Autowired
	AuthenticatedJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "salary", "deadline", "description");
	}

	@Override
	public Collection<Job> findMany(final Request<Job> request) {
		assert request != null;

		Collection<Job> result;

		//TODO: confirmar que hay que usar un tipo date y no un Calendar y revisar todos los entregables.
		//
		//
		//
		Date actualDate = new Date();

		result = this.repository.findManyActiveJob(actualDate);

		return result;
	}

}
