package keycloak.sms.service;

import org.keycloak.Config;
import org.keycloak.authentication.Authenticator;
import org.keycloak.authentication.AuthenticatorFactory;
import org.keycloak.models.AuthenticationExecutionModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.List;


public class SmsAuthenticatorFactory implements AuthenticatorFactory {

	public static final String PROVIDER_ID = "sms-authenticator";

	@Override
	public String getId() {
		return PROVIDER_ID;
	}

	@Override
	public String getDisplayType() {
		return "SMS";
	}

	@Override
	public String getHelpText() {
		return "Envoyer un OTP via SMS";
	}

	@Override
	public String getReferenceCategory() {
		return "otp";
	}

	@Override
	public boolean isConfigurable() {
		return true;
	}

	@Override
	public boolean isUserSetupAllowed() {
		return true;
	}

	@Override
	public AuthenticationExecutionModel.Requirement[] getRequirementChoices() {
		return REQUIREMENT_CHOICES;
	}

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		return List.of(
			new ProviderConfigProperty("length", "Code length", "le nombre des chiffres dans le code OTP", ProviderConfigProperty.STRING_TYPE, 6),
			new ProviderConfigProperty("ttl", "Time-to-live", "le nombre des secondes le code OTP sera valide", ProviderConfigProperty.STRING_TYPE, "300"),
			new ProviderConfigProperty("senderId", "SenderId", "Le nom de l'expéditeur qui s'affichera sur le téléphone du récépteur.", ProviderConfigProperty.STRING_TYPE, "Keycloak"),
			new ProviderConfigProperty("simulation", "Simulation mode", "En mode simulation, le code ne sera pas envoyé par SMS.Par contre, il va être affiché dans les journaux du serveur.", ProviderConfigProperty.BOOLEAN_TYPE, true)
		);
	}

	@Override
	public Authenticator create(KeycloakSession session) {
		return new SmsAuthenticator();
	}

	@Override
	public void init(Config.Scope config) {
	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {
	}

	@Override
	public void close() {
	}

}
