CREATE TABLE IF NOT EXISTS kyc_result
(
	token      varchar(64) VISIBLE not null,
	user_token varchar(64) VISIBLE not null,
	kyc_result varchar(64) VISIBLE,
	PRIMARY KEY(token)
);
