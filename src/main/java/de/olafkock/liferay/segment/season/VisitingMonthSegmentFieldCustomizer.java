package de.olafkock.liferay.segment.season;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.segments.field.customizer.SegmentsFieldCustomizer;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate=true,
		property={
				"segments.field.customizer.entity.name=Context",
				"segments.field.customizer.key=" + VisitingMonthSegmentKey.KEY,
				"segments.field.customizer.priority:Integer=100"
		},
		service=SegmentsFieldCustomizer.class
	)
public class VisitingMonthSegmentFieldCustomizer implements SegmentsFieldCustomizer {

	@Override
	public List<String> getFieldNames() {
		return _fieldNames;
	}
	
	@Override
	public String getLabel(String fieldName, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "visiting-month-field-label");
	}
	
	@Override
	public String getKey() {
		return VisitingMonthSegmentKey.KEY;
	}

	private static final List<String> _fieldNames = ListUtil.fromArray(
		new String[] {VisitingMonthSegmentKey.KEY, "honk"});
	
}
