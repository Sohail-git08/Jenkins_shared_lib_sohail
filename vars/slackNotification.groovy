def slackNotification(String buildStatus='STARTED'){
	//build status of null means SUCCESS
	buildStatus = buildStatus ?:'SUCCESS'
	
	//Default values
	def colorName='RED'
	def colorCode='#FF0000'
	def subject="${buildStatus}: Job '{env.JOB_NAME} [${env.BUILD_NUMBER}]'"
	def summary="${subject} (${env.BUILD_URL})"
	
	//over ride default values based on buildStatus
	if(buildStatus == 'STARTED'){
		colorName='YELLOW'
		colorCode='#FFFF00'
	}
	else if(buildStatus == 'SUCCESS'){
		colorName='GREEN'
		colorCode='#00FF00'
	}
	else{
		colorName='RED'
		colorCode='#FF0000'
	}
	
	//send notification
	slackSend(color: colorCode,message: summary)

}
