# OnlineCourseScheduler
## Title: System Requirement Specification for Online Course Scheduler
 
## Team :
   Students,
   Faculty,
   Supervisor,
   Director,
   Architect,
   Quality Assurance,
   System Analyst
   

## Objective :

The Online Course Scheduler for Transflower learning Website is intended to provide complete solutions for students, trainers as well as internal users (Staff) through a single Gateway using the internet. It will enable the institute to set up an online schedule, and students and trainers will be able to browse the online schedules and see their schedules online without visiting the institute physically.

## Scope :

This System will allow the institute to maintain the schedule of different courses, adding or deleting the course or batches from the schedule based on their availability.

Students will be able to select batches according to their choice and view respective schedules.

Faculty will be able to see their schedule and can request to modify/cancel the program.

The supervisor will be able to create new schedules and batches, see and modify existing batches, and approve faculty's and student's request.
		

## Definition :
- OCS: Online Course Scheduler
- QA:  Quality Assurance
- Portal: Personalized Online Web Application
- CRM: Customer Relation Management
- BI:  Business Intelligence
- KPI: Key Perfomornace Indicator
 

## Functional Requirements :

Students will be able to see the schedule of their respective batches and request for changing the batch. 

Faculty will be able to see the schedule for batches they are going to conduct and request to cancel the batches before 24 hrs.

Director will be able to see the schedule of all courses and also can recommend the supervisor to make changes if needed.

The supervisor will be able to decide the duration of a particular course, session, and batch.
The supervisor will be able to modify the schedule by adding/canceling the batches and approving/canceling the request of the student to change the batch.
The supervisor will be able to approve the request submitted by the trainer for cancellation and can reschedule the session.

Students, Faculties, supervisors, and directors will be able to check the status of the current conducting course.



## NonFunctional Requirement :

### Security :

Registered Students will allowed to see schedule online . Each stakeholder will able  to access system through authentication process. Who are you ? System will provide access to the content , operations using Role based security (Authorization) (Permissions based on Role) Using SSL in all transactions which will be performed stakeholder. It would protect confidential information shared by system to stake holder of Shared by stakeholder to system. System will automatically log of all stakeholder after some time due to inactiveness. System will block operations for inactive stakeholder and would redirect for authentication. System will internally maintain secure communiction channel between Servers ( Web Servers, App Servers, databse Server) Sensitive data will be always encrypted across communcation. User proper firewall to protect servers from out side fishing, velnerable attacks.

	
   
### Reliability :

The system will backup business data on regular basis and recover in short time duration to keep system operational Continous updates are matained , continous Adminstration is done to keep system operational. During peak hours system will maintain same user experaince by managing load balacning .

### Maintainability :

A  database software will be used to maintain System data Persistence. A readymade Web Server will be installed to host online course scheduler (WebSite) to management server capabilities. IT operations team will easily monitor and configure System using Adminstrative tools provided by Servers. Separate enviornment will be maintained for system for isolation in production, testing, and development.

### Portablility :

PDA: Portable Device Application System will provide portable User Interface ( HTML, CSS, JS) through users will be able to access online course scheduler. System can be deployed to single server, multi server, to any OS, Cloud (Azure or AWS or GCP)

### Accessibility :

Only registered students and trainers will be able to see schedule after authentication.Supervisor will be able to prepare/modify schedule. Director will be able to view all course's schedule. 

### Durability :

System will retain schedule of previous and current batches also.System will implement backup and recovery for retaining stake holders data, bussiness operation data and business data over time.


### Efficiency :
Many number of users will use online course scheduler portal with same response time.System will be able to manage all user traffic.

### Modularity :
System will be designed and developed using reusable, independent or dependent business senarios in the form of modules. These modules will be loosely coupled and highly cohesive. The system will contain a login module,role management module.

### Scalability :
System will be able to provide consistent user exeprience to stake holder as well as vistors irrespective of load.

### Safety :
online course schedule will be secure from malicious attack, and fishing. online course shedulars functionalities are protected from outside with proper firewall configuration. online course scheduler will be always kept updated with the latest anti virus software. Business data will be backed up periodically to ensure safty of data using an incremental back up strategy. Role based security will be applied for Application data and operations accessibility.


		

