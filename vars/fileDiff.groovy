def info(String text, String listFile, String buildUrl){
    def bodyHtml = ""
    def count = 0
    def indexFile = 0
    
    if (listFile != '') {
        def arrFile = listFile.split(',')
        bodyHtml += """<p>Check build changes on Jenkins <b><a href="${buildUrl}/last-changes">here</a></b>.</p><br>
                        <p><b>Files Diff</b></p>"""

        text.split("\n").each {
            param ->
            if (param.startsWith('Index:')) {   
                if (count >0) {
                    bodyHtml += "<br>"
                }
                count = 0;                        
                bodyHtml +="<span><b>" + param+ "</b></span><br>"   
                
                // call php file to check syntax
                def test =  callSh(arrFile[indexFile])
                //result check
                bodyHtml += "&nbsp;&nbsp; <b> * Check Syntax: ${test}</b><br>"     

                indexFile++                
            } else if (count <= 4){
                bodyHtml +="<span>" + param+ "</span><br>"
            } else {
                if (param.startsWith('-')){
                    bodyHtml +="<code style='background-color:#fdaeb7; white-space:pre-wrap'>" + param.replace("<", "&lt;").replace(">","&gt;") +"</code>"
                } else if(param.startsWith('+')) {
                    bodyHtml +="<code style='background-color:#bef5cb; white-space:pre-wrap'>" + param.replace("<", "&lt;").replace(">","&gt;") +"</code>"
                } else {
                    bodyHtml +="<code style='white-space:pre'>" + param.replace("<", "&lt;").replace(">","&gt;") + "</code>"
                }
            }            
            count++            
        }
    }
    
    return bodyHtml
}

//func call php file to check syntax
def callSh(file1){
    def res = sh( script: "php CheckSyntax.php ${file1}", returnStdout: true)
  return res
}