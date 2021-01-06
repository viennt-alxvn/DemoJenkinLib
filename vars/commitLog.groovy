def get() {
  // def env
  // def currentBuild

  echo "env ${this.env.BRANCH_NAME}"
  
  // def log = ""
  //       def changeLogSets = script.currentBuild.changeSets
  //        echo "c ${changeLogSets.size()}"
  //       for (int i = 0; i < changeLogSets.size(); i++) {
  //           def entries = changeLogSets[i].items
  //           for (int j = 0; j < entries.length; j++) {
  //               def entry = entries[j]
  //               log += "<b>Branch:</b> " + env.BRANCH_NAME
  //               log += "<br>"
  //               log += "<b>Commit:</b> ${entry.commitId} "
  //               log += "<br>"
  //               log += "<b>Author:</b> ${entry.author} "
  //               log += "<br>"
  //               log += "<b>Date:</b> ${new Date(entry.timestamp)} "
  //               log += "<br>"
  //               log += "<b>Message:</b> ${entry.msg} "
  //               log += "<br>"
  //               log +="<b>Changed Paths:</b>"
  //               log += "<br>"
  //               def files = new ArrayList(entry.affectedFiles)
  //               for (int k = 0; k < files.size(); k++) {
  //                   def file = files[k]
  //                   listFile += "${file.path},"
  //                   log += "<b> &nbsp;&nbsp; ${file.editType.name} -- ${file.path} </b><br>"
  //               }
  //               log+="---------------------------<br>"
  //           }
  //       }
  //   return log;
}
