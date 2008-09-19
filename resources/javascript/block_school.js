function initializeSchoolDoubleDropdowns() {
	$ES("select.schoolTypeDropdown").each(function(item) {
		item.addEvent('change', function(e){
			SchoolBusiness.findAllSchoolsByTypeDWR(e.target.value, {
				callback: function(result) {
					var index = e.target.id.lastIndexOf('_');
					if(index > 0) {
						index = e.target.id.substring(index + 1);
						dwr.util.removeAllOptions($('prm_school_' + index));
						dwr.util.addOptions($('prm_school_' + index), result, 'id', 'value');
					}
					
				}
			});
		});
	});
	$ES("select.schoolDropdown").each(function(item) {
		item.addEvent('change', function(e){
			SchoolBusiness.findAllGroupsBySchoolDWR(e.target.value, {
				callback: function(result) {
					var index = e.target.id.lastIndexOf('_');
					if(index > 0) {
						index = e.target.id.substring(index + 1);
						dwr.util.removeAllOptions($('prm_school_' + index));
						dwr.util.addOptions($('prm_school_' + index), result, 'id', 'value');
					}
					
				}
			});
		});
	});
}