
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.framework.entities.DomainEntity;

@Entity
public class Application extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//TODO:	(unique, pattern(EEEE-JJJJ:WWWW))
	@NotNull
	@Pattern(regexp = "/.")
	private String				referenceNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;
	//TODO: ENUM	
	//    Status (pending/accepted/rejected)
	@NotBlank
	private String				statement;

	@NotBlank
	private String				skills;

	@NotBlank
	private String				qualifications;
}
