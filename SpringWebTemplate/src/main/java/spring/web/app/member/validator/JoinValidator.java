package spring.web.app.member.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import spring.web.app.common.model.UserModel;

public class JoinValidator  implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String ID_PASSWORD_PATTEN = "[a-zA-Z0-9]";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String MOBILE_PATTERN = "[0-9]{10}";

	@Override
	public boolean supports(Class<?> clazz) {
		return UserModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserModel user = (UserModel) target;
		// userid
		pattern = Pattern.compile(ID_PASSWORD_PATTEN);
		matcher = pattern.matcher(user.getUserId());
		if (user.getUserId().length() < 4 || user.getUserId().length() > 15) {
			errors.rejectValue("userId", "join.userId.length");
		} else if(matcher.matches()){
			errors.rejectValue("userId", "join.userId.regex");
		}

		// password
		matcher = pattern.matcher(user.getPassword());
		if (user.getPassword().length() < 8 || user.getPassword().length() > 15) {
			errors.rejectValue("password", "join.password.length");
		} else if (matcher.matches()) {
			errors.rejectValue("password", "join.password.regex");
		}

		// name
		if (user.getUserName().length() < 2 || user.getUserName().length() > 20) {
			errors.rejectValue("userName", "join.userName.length");
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
