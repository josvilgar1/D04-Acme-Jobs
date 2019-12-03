
package acme.features.sponsor.commercial;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.banners.Commercial;
import acme.entities.roles.Sponsor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@RequestMapping("/sponsor/commercial")
@Controller
public class SponsorCommercialBannerController extends AbstractController<Sponsor, Commercial> {

	@Autowired
	private SponsorCommercialBannerListMineService	listMineService;

	@Autowired
	private SponsorCommercialBannerShowService		showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
