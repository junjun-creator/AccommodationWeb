	function doOpenCheck(chk){
                  var checks = document.getElementsByName("check");
                  for(var i=0; i<checks.length; i++){
                      if(checks[i] != chk){
                          checks[i].checked = false;
                      }
                  }
              }

