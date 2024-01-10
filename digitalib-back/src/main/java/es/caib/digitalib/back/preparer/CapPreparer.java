package es.caib.digitalib.back.preparer;

import javax.annotation.security.RunAs;

import org.apache.log4j.Logger;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Component;
import es.caib.digitalib.commons.utils.Constants;

/**
 * @author GenApp
 *
 */
@RunAs(Constants.DIB_USER)
@Component
public class CapPreparer implements ViewPreparer {

	protected final Logger log = Logger.getLogger(getClass());

	@Override
	public void execute(Request tilesRequest, AttributeContext attributeContext) throws PreparerException {

		// TODO GENAPP Select available languages

	}
}