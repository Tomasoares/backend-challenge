package com.invillia.acme.service.impl.util;

import org.jooq.LikeEscapeStep;
import org.jooq.Record;
import org.jooq.TableField;

public class JooqUtils {


	public static LikeEscapeStep like(TableField<? extends Record, String> field, String parameter) {
		return field.lower().like("%" + parameter.toLowerCase() + "%");
	}
}
