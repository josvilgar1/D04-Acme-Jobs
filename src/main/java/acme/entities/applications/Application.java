
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	//TODO:	(unique, pattern(EEEE-JJJJ:WWWW))
	@NotBlank
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

	//Relationships ---------------------------------------
}
