package de.olafkock.liferay.segment.season;

import com.liferay.segments.context.Context;
import com.liferay.segments.context.contributor.RequestContextContributor;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate=true,
		property= {
				"request.context.contributor.key=" + VisitingMonthSegmentKey.KEY,
				"request.context.contributor.type=Integer"
		},
		service=RequestContextContributor.class
	)
public class VisitingMonthSegmentRequestContextContributor implements RequestContextContributor {
	@Override
	public void contribute(Context context, HttpServletRequest httpServletRequest) {
		if(!context.containsKey(VisitingMonthSegmentKey.KEY)) {
			int month = Calendar.getInstance().get(Calendar.MONTH);
			context.put(VisitingMonthSegmentKey.KEY, (Integer)(month+1));
		}
	}
}

