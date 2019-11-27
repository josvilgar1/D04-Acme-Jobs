
package acme.features.authenticated.messagethread;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.messagethreads.Messagethread;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("authenticated/messagethread")
public class AuthenticatedMessagethreadController extends AbstractController<Authenticated, Messagethread> {

	@Autowired
	private AuthenticatedMessagethreadListService	listService;

	@Autowired
	private AuthenticatedMessagethreadShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
