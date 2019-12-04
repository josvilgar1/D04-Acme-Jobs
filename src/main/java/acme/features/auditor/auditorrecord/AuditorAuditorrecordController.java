
package acme.features.auditor.auditorrecord;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.auditrecords.Auditrecord;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("auditor/auditrecord")
public class AuditorAuditorrecordController extends AbstractController<Auditor, Auditrecord> {

	@Autowired
	private AuditorAuditrecordShowService		showService;

	@Autowired
	private AuditorAuditrecordListByJobService	listByJobService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addCustomCommand(CustomCommand.LIST_JOB, BasicCommand.LIST, this.listByJobService);

	}
}
