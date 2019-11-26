
package acme.entities.roles;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;

import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sponsor extends UserRole {

	// Serialization identifier -----------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ---------------------------------------

	@NotBlank
	private String				organizationName;

	@CreditCardNumber
	private String				creditCardNumber;

	private String				creditCardName;

	@Range(min = 1, max = 12)
	private Integer				creditCardMonth;

	@Min(value = 2019)
	private Integer				creditCardYear;

	@Range(min = 1, max = 999)
	private Integer				creditCardCVV;

	private String				creditCardType;

	//Derived attributes --------------------------------

	//Relationships -------------------------------------

}
