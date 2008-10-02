function initializeSchoolDoubleDropdowns() {
	$ES("select.schoolTypeDropdown").each(function(item) {
		item.addEvent('change', function(e) {
			if (item.id == null) {
				return false;
			}
			
			SchoolBusiness.findAllSchoolsByTypeDWR(dwr.util.getValue(item.id), {
				callback: function(result) {
					var index = item.id.lastIndexOf('_');
					if(index > 0) {
						index = item.id.substring(index + 1);
						dwr.util.removeAllOptions($('prm_school_' + index));
						dwr.util.addOptions($('prm_school_' + index), result, 'id', 'value');
					}
					
				}
			});
		});
	});
	$ES("select.schoolDropdown").each(function(item) {
		item.addEvent('change', function(e) {
			if (item.id == null) {
				return false;
			}
			
			SchoolBusiness.findAllGroupsBySchoolDWR(dwr.util.getValue(item.id), {
				callback: function(result) {
					var index = item.id.lastIndexOf('_');
					if(index > 0) {
						index = item.id.substring(index + 1);
						dwr.util.removeAllOptions($('prm_school_' + index));
						dwr.util.addOptions($('prm_school_' + index), result, 'id', 'value');
					}
					
				}
			});
		});
	});
}