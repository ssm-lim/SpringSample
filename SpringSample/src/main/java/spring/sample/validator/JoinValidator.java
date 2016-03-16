package spring.sample.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spring.sample.model.User;

public class JoinValidator implements Validator {
	
	private Pattern pattern;
	private Matcher matcher;

	private static final String ID_PASSWORD_PATTEN = "[a-zA-Z0-9]";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String MOBILE_PATTERN = "[0-9]{10}";

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		// userid
		pattern = Pattern.compile(ID_PASSWORD_PATTEN);
		matcher = pattern.matcher(user.getUserid());
		if (user.getUserid().length() < 4 || user.getUserid().length() > 15) {
			errors.rejectValue("userid", "join.userid.length");
		} else if(matcher.matches()){
			errors.rejectValue("userid", "join.userid.regex");
		}

		// password
		matcher = pattern.matcher(user.getPassword());
		if (user.getPassword().length() < 8 || user.getPassword().length() > 15) {
			errors.rejectValue("password", "join.password.length");
		} else if (matcher.matches()) {
			errors.rejectValue("password", "join.password.regex");
		}

		// name
		if (user.getName().length() < 2 || user.getName().length() > 20) {
			errors.rejectValue("name", "join.name.length");
		}
		
		// email
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "join.email.regex");
		}
		
		// gender
		if (user.getGender() == null || user.getGender().length() < 1) {
			errors.rejectValue("gender", "join.gender.empty");
		}
		
		// interests
		if (user.getInterests() == null || user.getInterests().length < 1) {
			errors.rejectValue("interests", "join.interests.empty");
		}
	}

}
