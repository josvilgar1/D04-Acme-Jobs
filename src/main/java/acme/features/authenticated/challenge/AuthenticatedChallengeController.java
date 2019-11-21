
package acme.features.authenticated.challenge;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.challenges.Challenge;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("authenticated/challenge")
public class AuthenticatedChallengeController extends AbstractController<Authenticated, Challenge> {

	@Autowired
	private AuthenticatedChallengeListAllActiveService	listAllActiveService;

	@Autowired
	private AuthenticatedChallengeListService			listService;

	@Autowired
	private AuthenticatedChallengeShowService			showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

		super.addCustomCommand(CustomCommand.LIST_ALL_ACTIVE, BasicCommand.LIST, this.listAllActiveService);
	}

}
