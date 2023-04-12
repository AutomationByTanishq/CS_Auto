package Pages;

import java.io.File;

public class Abstract {

    public String LEGACY_LOGIN_URL_PRE = "https://csutraapp-dev.azurewebsites.net/";
    public String LEGACY_LOGIN_TXT_USERNAME_VALUE = "rahuld+11@perfectqaservices.com";
    public String LEGACY_LOGIN_TXT_PASSWORD_VALUE = "Rahul@123";
    public String LEGACY_LOGIN_TXT_USERNAME = "username";
    public String LEGACY_LOGIN_TXT_PASSWORD = "password";
    public String LEGACY_LOGIN_BTN_SUBMIT = "submit";
    static File file = new File("");
    static String str = file.getAbsolutePath();
    public static String LEGACY_IMAGE_PATH = str+"\\Images\\images.jfif";


    // Approver Settings locators
    public static String SettingsButton = "//img[@title='Settings']";
    public static String NameField = "//input[@id='name']";
    public static String DesignationField = "//label[normalize-space()='Designation:']//..//input";
    public static String DesignationFieldsignup = "//input[@id='Designation']";
    public static String MobileField = "//input[@id='mobile']";
    public static String SaveChangesButton = "//button[@class='btn save-changes-blue-btn']";

    public static String Alert = "//div[@role='alert']";
    public static String OTPField = "//input[@placeholder='Enter 6 digit OTP']";
    public static String SaveDetailsButton = "//button[@class='btn save-details common-button btn-width']";

    public static String SecurityMenuButton = "//span[normalize-space()='Security']";
    public static String ChangePasswordButton = "//p[normalize-space()='change password']";
    public static String CurrentPasswordField = "//input[@class='form-control falsefalse']";
    public static String NewPasswordField = "//div[@class='form-group ']//input[@placeholder='Enter password']";
    public static String ConfirmPasswordField = "(//input[contains(@placeholder,'Enter password')])[2]";
    public static String SavePasswordBButton = "//div[@class='col-2']//button[@class='btn save-changes-blue-btn'][normalize-space()='Save Password']";

    public static String LogoutButton = "//div[@class='second-icon-list']//div[3]//*[name()='svg']";
    public static String SubmitButton_Login = "//button[@type='submit']";
    public static String Yesbutton = "//button[normalize-space()='Yes']";
    public static String LoginTitle = "//p[@class='comtech_login_title']";

    public static String LoginButton = "//a[normalize-space()='Login']";
    public static String ComplianceOfficerEmailField = "//input[@placeholder='Enter your company email']";
    public static String ComplianceOfficerPasswordField = "//input[@placeholder='Enter your password']";

    public static String SidebarLogo = "//div[@class='logo']//img[@alt='sideBarlogo']";

    public static String Tasks_Header = "//div[text()='Tasks']";

    // Compliance Updates Locators

    public static String UpdatesMenu = "//div[@class='logo']//img[@alt='sideBarlogo']";
    public static String FirstUpdate = "//div[contains(@class,'col-md-12 regulations-scroll d-none d-md-block pl-0')][1]//div//div//div//div//div//div//div//h2";
    public static String SearchIconUpdates = "//div[contains(@class,'d-none d-md-flex')]//button[contains(@type,'button')]//*[name()='svg']";
    public static String SearchUpdateField = "//input[@class='styles_searchInput__eaD8_']";
    public static String SearchedUpdateTitle = "//h2[contains(@class,'new-regulation-title')]";
    public static String SelectAll = "//label[normalize-space()='Select All']";
    public static String Select13thUpdate = "//div[contains(@class,'col-md-12 regulations-scroll d-none d-md-block pl-0')][13]//div//div//div//div//input";
    public static String EmailLogButton = "//button[normalize-space()='Email Log']";
    public static String StartDateField = "//div[@class='ant-picker date-picker start-date']//div[@class='ant-picker-input']";
    public static String HeaderPrevButton = "//button[contains(@class,'ant-picker-header-prev-btn')]";
    public static String LastMonthFirstDate = "(//div[contains(@class,'ant-picker-cell-inner')][normalize-space()='1'])[1]";
    public static String EndDateField = "//input[contains(@name,'endDate')]";
    public static String TodaysDate = "//div[@class='ant-picker-dropdown ant-picker-dropdown-placement-bottomLeft ']//div[@class='ant-picker-footer']//a[@class='ant-picker-today-btn']";
    public static String RandomUpdate = "//div[contains(@class,'col-md-12 regulations-scroll d-none d-md-block pl-0')][1]//div//div//div//div//input";
    public static String SendEmailButton = "//button[normalize-space()='Send Email']";
    public static String SelectAllUsers = "//p[normalize-space()='Select All']//..//input[@class='checkBox']";
    public static String SendMailButton = "//button[normalize-space()='Send Mail']";
    public static String IdentifierID = "//input[@id='identifierId']";
    public static String NextButton = "//div[@class='VfPpkd-RLmnJb']//..//span[normalize-space()='Next']";
    public static String PasswordField = "//input[@name='Passwd']";
    public static String NextButtonPass = "//span[normalize-space()='Next']";
    public static String InboxButton = "//a[normalize-space()='Inbox']";
    public static String RefreshButton = "//div[@class='T-I J-J5-Ji nu T-I-ax7 L3']//div[@class='asa']";
    public static String FirstMail = "(//td[@role='gridcell'])[1]";
    public static String MailTitle = "//div[@name='^i'][normalize-space()='Inbox']//..//..//..//h2";

    // Compliance Notifications locators

    public static String NotificationMenuButton = "//img[@title='Notifications']";
    public static String NotificationFilterDropdown = "//div[@class='Dropdown-placeholder is-selected']";
    public static String ApprovedOption = "//div[normalize-space()='Approved']";
    public static String VerifyNotification = "//div[@id='scrollableList']//.//ul[1]//.//li[2]";
    public static String TaskStatus = "//div[contains(@class,'border-header d-none d-md-block w-100')]//div[contains(@class,'task-status__container d-none d-md-block align-center')]";
    public static String NoNotificationFound = "//h1[normalize-space()='No notification found']";
    public static String AssignedOption = "//div[contains(@role,'option')][normalize-space()='Assigned']";
    public static String TaskOption = "//div[normalize-space()='Tasks']";
    public static String UpdatesOption = "//div[normalize-space()='Updates']";
    public static String UpdateTitle = "//h3[@class='mb-2']";
    public static String RejectedOption = "//div[normalize-space()='Rejected']";
    public static String ReassignedOption = "//div[normalize-space()='Reassigned']";
    public static String CommentOption = "//div[normalize-space()='Comment']";
    public static String AllNotificationsOption = "//div[@role='option'][normalize-space()='All notifications']";
    public static String Notification = "//div[@id='scrollableList']//.//ul[1]//.//span[@class='styles_strongTitle__3CQiJ']";
    public static String SearchNotification = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']//*[name()='svg']";
    public static String TaskNameField = "//input[@type='text']";
    public static String NotificationMessage = "//div[@class='styles_noResultFound__notification__irLdu']";

    // Approver Task Project Locators

    public static String InvalidUserNamePasswordValidationMessage = "//div[@class='row get-login-mobile']//div[@role='alert'][normalize-space()='Invalid username and password !!!']";
    public static String ProjectTaskIcon = "//img[@title='Project Task']";
    public static String AddNewProjectButton = "//button[@title='Add New Project']";
    public static String ProjectNameInputField = "//input[@name='project_name']";
    public static String Dropdown = "//div[@class=' css-1wa3eu0-placeholder']";
    public static String SelectUserFromDropdown = "//div[contains(text(),'Team Mem')]";
    public static String StartDateInputField = "//input[@name='start_date']";
    public static String SelectToday = "//a[normalize-space()='Today']";
    public static String EndDate = "(//input[@placeholder='Select date'])[2]";
    public static String NextArrowCal = "(//span[contains(@class,'ant-picker-next-icon')])[2]";
    public static String NextMonthDate = "/html/body/div[3]/div/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td[6]";
    public static String RDWEditor = "//div[contains(@aria-label,'rdw-editor')]";
    public static String SubmitButton = "//button[normalize-space()='Submit']";
    public static String Alert1 = "//div[contains(@role,'alert')]";
    public static String DeleteIcon = "//button[@class='mr-2 false project-management__small-icon-button project-management__small-icon-button--danger']";
    public static String YesButton = "//button[@class='project-management__button project-management__button--primary']";
    public static String TrashMenu = "//img[@title='Project Trash']";
    public static String EditIcon = "//button[@class='mr-2 false project-management__small-icon-button project-management__small-icon-button--danger']//img[@alt='edit-icon']";
    public static String AddMileStoneButton = "//button[normalize-space()='M']";
    public static String MileStoneTitleField = "//input[@id='milestone-title']";
    public static String DatePicker1 = "(//div[@class='ant-picker-input'])[1]";
    public static String DatePicker2 = "//div[@class='ant-picker modal-input']//div[@class='ant-picker-input']";
    public static String EndDateToday = "(//a[contains(text(),'Today')])[2]";
    public static String MileStoneHeaderMenu = "//p[contains(@class,'undefined mb-0 project-management__page-display mr-4 px-1 text-center')][normalize-space()='Milestone']";
    public static String PlusIconAddNewTask = "//button[3]//*[name()='svg']";
    public static String TaskListNameField = "//input[@class='modal-input']";
    public static String MileStoneName = "//div[@class='form-group w-100']";
    public static String EditButtonTaskList = "//div[@class='d-flex align-items-center justify-content-between']//button[@title='Edit']";


    //CO Setting Locators
    public static String OTPInput= "//input[@class='form-control  input-not-blank ']";
    public static String CO_SaveDetailsButton= "//button[normalize-space()='submit otp']";
    public static String CompanyMenuOnSettingPage= "//span[normalize-space()='Company']";
    public static String AddAnotherCompanyButton= "//table//caption[contains(text(),'Add another company')]";
    public static String CompanyNameInputField= "//td[@class='companyName']//input[@placeholder='Company Name']";
    public static String CompanyTypePrivateLimited= "//input[contains(@placeholder,'Company Name')]//..//..//td[contains(@class,'dropList')][1]//div[@class=' css-1hwfws3']";
    public static String CO_ListBoldTitle= "//input[@id='nameInputBox1']//..//..//td[@class='dropList'][2]//.//div[@class='holding-list-bold-title']";
    public static String CountryIndia= "(//div[contains(@class,'css-1uccc91-singleValue')][normalize-space()='India'])[4]";
    public static String PinCodeInputField= "(//input[@placeholder='Pincode'])[4]";
    public static String CO_Number= "(//div)[238]";
    public static String GeneralOption= "//div[contains(text(),'General')]";
    public static String CO_T_Body= "//tbody/tr[3]/td[6]/div[1]/span[1]";
    public static String AssignToMeOption = "//div[@class='shadow-tooltip']//div//button[@class='btn save-details assign-me'][normalize-space()='Assign to me']";
    public static String GSTINNumberInputField= "//tbody/tr[3]/td[7]/input[1]";
    public static String AddLicenceButton= "//button[@id='addLicense2']";
    public static String ChooseLicenceCheckBox= "(//input[@type='checkbox'])[1]";
    public static String LicenceSelectedButton= "//button[normalize-space()='2 Licenses Selected']";
    public static String CheckIcon= "//img[@alt='check Icon']";
    public static String TeamMemberMenu= "//span[normalize-space()='Team Members']";
    public static String AddNewButtonOnTeamMemberMenu= "//div[contains(@class,'add-new-plus mr-2 cursor-pointer')]";
    public static String FullNameInputField= "//input[contains(@placeholder,'Full name')]";
    public static String SelectRoleInputField= "//tr[contains(@class,'focusRemove')]//input[contains(@placeholder,'Select Role')]";
    public static String TeamMemberRoleInDropDown= "//div[contains(@class,'searchable__list')]//div[contains(@class,'')][normalize-space()='Team Member']";
    public static String EmailInputField= "//div[contains(@class,'form-group mb-0')]//input[contains(@placeholder,'Enter email')]";
    public static String CO_InviteButton= "//button[@class=' btn save-details common-button btn-width ']";
    public static String SearchIcon= "//div[@class='right-search-bar']//button[@type='button']//*[name()='svg']		";
    public static String CreatedUser= "//input[@class='form-control setPlaceHolder']";
    public static String CreatedUserInList= "//div[@class='nameCirle']";
    public static String DeleteMemberButton= "//div[contains(@class,'last-td last-td__open')]//div[contains(@class,'delete-member')]";
    public static String DeleteRecordButton= "//button[@class='btn delete-Record']";
    public static String CloseButton= "//button[@aria-label='close']//*[name()='svg']";
    public static String LogoutIcon= "//div[@class='second-icon-list']//div[3]//*[name()='svg']";
    public static String SignInLabel= "//span[normalize-space()='Sign in']";
    public static String AcceptInvitationButtonInReceivedMail= "//p[contains(text(),'Invitation to join')]//..//..//..//a[normalize-space()='Accept Invitation']";
    public static String FullNameInput= "//input[@id='FullName']";
    public static String MobileNumberInputField= "//input[@id='MobileNumber']";
    public static String PasswordInputField= "//input[@id='Password']";
    public static String ConfirmPasswordInputField= "//input[@id='ConfirmPassword']";
    public static String COSaveDetailsButton= "//button[normalize-space()='SAVE DETAILS']";
    public static String SecureNowButton= "//button[@class='btn save-details common-button']";
    public static String OTPInputField= "//input[@id='OTP']";
    public static String VerifyButton= "//button[@class='btn save-details common-button mt-0']";
    public static String RightInputRow= "//div//input[@class='form-control right-input-row']";
    public static String TrashIcon= "//img[@title='Trash']";
    public static String CO_DeleteIcon= "//div[@class='project-data-container__3 d-none d-md-flex align-items-center justify-content-between'][1]//button[@title='Delete Task']";

    //CO Dashboard Locators
    public static String OverDueMenu= "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Overdue']";
    public static String DashboardHeaderTitleActive= "//p[@class='styles_dashboardHeaderTitle__3Hik3 styles_dashboardHeaderTitleActive__1Em6B']";
    public static String AllCount= "//p[contains(text(),'All')]//div";
    public static String AssignedToMeCount= "//p[contains(normalize-space(),'Assigned To Me')]//div";
    public static String AssignedToOthersCount= "//p[contains(normalize-space(),'Assigned To Others')]//div";
    public static String NotAssignedCount= "(//p[contains(text(),'Not Assigned')])[1]//div";
    public static String TodayMenu= "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Today']";
    public static String Next6DaysMenu = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Next 6 Days']";
    public static String CO8To30DaysMenu = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='8 to 30 Days']";
    public static String Beyond30DaysMenu = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Beyond 30 Days']";
    public static String TotalMenu = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Total']";
    public static String CompleteMenu = "//div[contains(@class,'col-12 col-md-3 d-none d-md-block')]//button[contains(@type,'button')][normalize-space()='Completed']";
    public static String CODashboardHeaderTitleActive = "//p[contains(@class,'styles_dashboardHeaderTitle__3Hik3 styles_dashboardHeaderTitleActive__1Em6B')]";
    public static String AssignMeCount = "//p[contains(normalize-space(),'Completed By Me')]//div";
    public static String COAssignedToOthersCount = "//p[contains(normalize-space(),'Completed By Others')]//div";
    public static String DashboardAnalyticsTotalCount = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Overdue']//..//..//.//div[@class='count-container cursor-pointer']";
    public static String CODashboardAnalyticsTotalCount = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Today']//..//..//.//div[@class='count-container cursor-pointer']";
    public static String CO_DashboardAnalyticsTotalCount = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Next 6 Days']//..//..//.//div[@class='count-container cursor-pointer']";
    public static String DashboardAnalyticsTotalCount8To30Days = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='8 to 30 Days']//..//..//.//div[@class='count-container cursor-pointer']";
    public static String DashboardAnalyticsTotalCountBeyond30Days = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Beyond 30 Days']//..//..//.//div[@class='count-container cursor-pointer']";
    public static String DashboardAnalyticsTotalCountTotal = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Total']//..//..//.//div[@class='count-container cursor-pointer']";
    public static String CO_CompleteMenu = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Completed']";
    public static String DashboardAnalyticsTotalCountComplete = "//div[@class='col-12 col-md-3 d-none d-md-block']//button[@type='button'][normalize-space()='Completed']//..//..//.//div[@class='count-container cursor-pointer']";

    //Aprover task project
    public static String ATP_TrashMenu = "//img[contains(@title,'Project Trash')]";
    public static String ATP_DeleteIconOnCreatedTask = "//button[@class='mr-2 undefined project-management__small-icon-button project-management__small-icon-button--danger']";
    public static String ATP_AddNewTaskButton = "//button[@title='Add New Task']";
    public static String SelectStartDateButton = "//a[@class='ant-picker-today-btn']";
    public static String SelectEndDate = "(//div[contains(@class,'ant-picker-input')])[2]";
    public static String TaskDescriptionInputField = "(//input[contains(@class,'modal-input')])[2]";
    public static String AssignTo = "//div[@class=' css-1hwfws3']";
    public static String CommentInputField = "(//input[@class='modal-input'])[3]";
    public static String SelectTime = "//input[@placeholder='Select time']";
    public static String SelectTimeNow ="//a[normalize-space()='Now']";
    public static String LabelAttachmentFilesInput ="//label[@for='attachment-file-input,attachment_files']";
    public static String ATP_TaskMenu ="//p[contains(@class,'undefined mb-0 project-management__page-display mr-4 px-1 text-center')][normalize-space()='Task']";
    public static String ATPTaskMenu ="//p[normalize-space()='Tasks']";
    public static String ATP_UpdateButton ="//button[normalize-space()='Update']";
    public static String SearchInputField ="(//input[@placeholder='Search for project, tasks, assigned to, assigned by and task owner'])[1]";
    public static String OverDueTask ="//p[normalize-space()='Overdue']//..//..//..//div[@class='row mb-3 mx-auto cursor-pointer no-gutters  styles_taskItemContainer__2lP2X  false'][1]";
    public static String ATP_TaskStatus ="//div[contains(@class,'border-header d-none d-md-block w-100')]//div[contains(@class,'task-status__container d-none d-md-block align-center')]//p[contains(@class,'task-status__text--task-detail')]";
    public static String CentreText ="//div[@class='text-center']";
    public static String CommentMenu ="//div[contains(text(),'Comments')]";
    public static String AddCommentTextArea ="//textarea[@placeholder='Add a comment']";
    public static String SubmitIcon ="//div[@class='inputIcon']//img";
    public static String ATP_FilesMenu ="//div[@class='file-title unActiveText-color pointer']";
    public static String ATP_MarkCompleteButton ="//button[normalize-space()='Mark Complete']";
    public static String TakeActionTask ="//p[normalize-space()='Take Action']//..//..//..//div[@class='row mb-3 mx-auto cursor-pointer no-gutters  styles_taskItemContainer__2lP2X  false'][1]";
    public static String UpcomingTask ="//p[normalize-space()='Upcoming']//..//..//..//div[@class='row mb-3 mx-auto cursor-pointer no-gutters  styles_taskItemContainer__2lP2X  false'][1]";
    public static String ATP_ProfileIcon ="//img[@title='Profile']";
    public static String ATP_LogoutButton ="//div[@class='logout-label-option border-0']";
    public static String ATP_SearchIcon ="//img[@alt='search-icon']";
    public static String CreatedTaskNameInputField ="//input[@placeholder='search for license, teams, companies etc..']";
    public static String SearchedTask ="//div[contains(@class,'col-10 col-sm-11 col-md-5 d-flex')]";
    public static String TaskTitle ="//div[@class='task-details-sub-title']";
    public static String ATPTaskStatus ="//div[@class='border-header d-none d-md-block w-100']//p[@class='task-status__text--task-detail']";
    public static String ATPTaskStatus1 ="//div[@class='border-header d-none d-md-block w-100']//div[@class='task-status__container d-none d-md-block align-center']//p[@class='task-status__text--task-detail']";
    public static String TaskMenu1 ="//img[@title='Tasks']";
    public static String ATP_RejectTaskButton ="//button[normalize-space()='reject Task']";
    public static String ATP_CommentTextArea ="//textarea[@id='comment']";
    public static String EditButtonOnCreatedProject ="//button[@class='mr-2 project-management__small-icon-button project-management__small-icon-button--primary']//img[@alt='edit-icon']";







    // CO_task_project locators
    public static String AddNewTaskButton = "//button[@title='Add New Task']";
    public static String AntPickerButton = "//a[@class='ant-picker-today-btn']";
    public static String AntPickerInput = "(//div[contains(@class,'ant-picker-input')])[2]";
    public static String TaskDescriptionField = "(//input[contains(@class,'modal-input')])[2]";
    public static String AssignToField = "//div[@class=' css-1hwfws3']";
    public static String ModalInputField = "(//input[@class='modal-input'])[3]";
    public static String DailyRadioButton = "//span[normalize-space()='Daily']";
    public static String ProfileIcon = "//img[@title='Profile']";
    public static String COTasklogoutButton = "//div[@class='logout-label-option border-0']";
    public static String TaskMenu= "//img[@title='Tasks']";
    public static String SearchIconInTaskMenu= "//img[@alt='search-icon']";
    public static String SearchField= "//input[@placeholder='search for license, teams, companies etc..']";
    public static String SearchResult= "//div[@class='col-10 col-sm-11 col-md-5 d-flex ']";
    public static String TitleInSearchResult= "//div[@class='task-details-sub-title']";
    public static String FileUploadBox= "//div[@class='file-upload-box']";
    public static String CommentField= "//div[contains(text(),'Comments')]";
    public static String CommentInputBox= "//textarea[@placeholder='Add a comment']";
    public static String AddCommentButton= "//div[@class='inputIcon']";
    public static String FilesMenu= "//div[@class='file-title unActiveText-color pointer']";
    public static String MarkCompleteButton= "//button[normalize-space()='Mark Complete']";
    public static String SearchedTaskResult= "//div[contains(@class,'col-10 col-sm-11 col-md-5 d-flex')]";
    public static String COTaskStatus= "//div[@class='border-header d-none d-md-block w-100']//div[@class='task-status__container d-none d-md-block align-center']//p[@class='task-status__text--task-detail']";
    public static String ApproveTaskButton= "//button[normalize-space()='approve task']";
    public static String VerifyTaskStatus= "//div[@class='border-header d-none d-md-block w-100']//p[@class='task-status__text--task-detail']";
    public static String RejectTaskButton= "//button[normalize-space()='reject Task']";
    public static String CommentTextArea= "//textarea[@id='comment']";
    public static String AddMilestoneButton_CO_Task= "//button[normalize-space()='M']";
    public static String MilestoneTitleInput= "//input[@id='milestone-title']";
    public static String DatePickerInput= "(//div[@class='ant-picker-input'])[1]";
    public static String DatePickerInputTo= "//div[@class='ant-picker modal-input']//div[@class='ant-picker-input']";
    public static String TodayDate= "(//a[contains(text(),'Today')])[2]";
    public static String OverDueTaskOnDashboard= "//p[normalize-space()='Overdue']//..//..//..//div[@class='row mb-3 mx-auto cursor-pointer no-gutters  styles_taskItemContainer__2lP2X  false'][1]";
    public static String AssignedTask= "//div[contains(@class,'border-header d-none d-md-block w-100')]//p[contains(@class,'task-status__text--task-detail')][normalize-space()='Task Assigned']";
    public static String MarkCompleteBtn= "//button[contains(text(),'Mark Complete')]";
    public static String TaskStatusApprovalPending= "//div[@class='border-header d-none d-md-block w-100']//div[@class='task-status__container d-none d-md-block align-center']//p[contains (text(),'Approval Pending')]";
    public static String ApproveTaskBtn= "//button[contains(text(),'approve task')]";
    public static String AssignButton= "//div[@id='assignBtn']";
    public static String UserFromList= "//span[normalize-space()='rahuld+204@perfectqaservices.com']";
    public static String COMarkCompleteButton= "//button[@value='3']";
    public static String ApproverAssignStatus= "//div[contains(text(),'Approver')]//..//..//div[contains(text(),'Assign')]";
    public static String AssignMeButton= "//button[contains(text(),'Assign to me')]";
    public static String StatusTaskRejected= "//div[contains(@class,'border-header d-none d-md-block w-100')]//div[contains(@class,'task-status__container d-none d-md-block align-center')]//p[contains(@class,'task-status__text--task-detail')][normalize-space()='Task Rejected']";
    public static String PlusIconInCreatedMilestone= "//button[3]//*[name()='svg']";
    public static String ModalInputBox= "//input[@class='modal-input']";
    public static String NameOfMilestone= "//div[@class='form-group w-100']";
    public static String PlusIconToAddNewTask= "//button[@title='Add Task List']//*[name()='svg']";
    public static String ProjectTrashMenu= "//img[contains(@title,'Project Trash')]";
    public static String MilestoneHeaderMenu_CO_Task= "//p[contains(@class,'undefined mb-0 project-management__page-display mr-4 px-1 text-center')][normalize-space()='Milestone']";
    public static String DeleteIconOnCreatedTask= "//button[@class='mr-2 undefined project-management__small-icon-button project-management__small-icon-button--danger']";
    public static String AddNewTaskBtn= "//button[normalize-space()='T']";
    public static String TaskFieldOnHeader= "//div[contains(@class,'mt-3 mt-md-0')]//p[2]";
    public static String TaskFromHeaderMenuInTrashMenu= "//p[normalize-space()='Tasks']";
    public static String ProjectTaskMenu= "//img[contains(@title,'Project Task')]";
    public static String StatusNotAssigned= "//div[normalize-space()='Not Assigned']";
    public static String NotAssignedTask= "(//img[@alt='Right Arrow'])[1]";
    public static String InviteButton= "//div[@class='dropbox-add-line']";
    public static String StatusAlreadyExist= "//div[contains(text(),'Email already exists')]";
    public static String SelectTimeButton= "//input[@placeholder='Select time']";
    public static String SelectTimeNowButton= "//a[normalize-space()='Now']";
    public static String LabelAttachmentFiles= "//label[@for='attachment-file-input,attachment_files']";
    public static String COTaskMenu= "//p[contains(@class,'undefined mb-0 project-management__page-display mr-4 px-1 text-center')][normalize-space()='Task']";
    public static String TaskInTaskList= "//div[@class='upcoming-btn-pending']//..//..//div//a[3]";
    public static String CoTaskStatus= "//div[@class='border-header d-none d-md-block w-100']//div[@class='task-status__container d-none d-md-block align-center']";
    public static String AssignToButton= "(//div[contains(text(),'Assign')])[2]";
    public static String EnterNameOrEmailInputField= "//input[@placeholder='Enter name or email']";
    public static String CoInviteButton= "//div[@class='dropbox-add-line']//img[@alt='account Circle Purple']";
    public static String ValidationMessageEnterValidEmail= "//div[contains(text(),'Please Enter valid Email')]";
    public static String Edit_Icon= "//button[@class='mr-2 project-management__small-icon-button project-management__small-icon-button--primary']//img[@alt='edit-icon']";
    public static String UpdateButton= "//button[normalize-space()='Update']";
    public static String DateSelected= "//div[normalize-space()='17']";
    public static String ValidationMessageAddProject= "//div[@class='col-sm-6 col-lg-3']//label[normalize-space()='Start Date']//..//p[@class='add-project-err-msg']";
    public static String DateSelectButton= "(//button[@type='button'])[8]";
    public static String DateSelectedEndDate= "(//div[contains(text(),'19')])[2]";
    public static String EndDateValidation= "//div[@class='col-sm-6 col-lg-3']//label[normalize-space()='End Date']//..//p";
    public static String DateSelectedStartDate= "//button[@class='ant-picker-header-prev-btn']";
    public static String ErrorMessageAddProject= "(//p[contains(@class,'add-project-err-msg')])[1]";
    public static String DatePickerPrevButtonOnHeader= "(//button[@class='ant-picker-header-prev-btn'])[2]";
    public static String DateSelectedLastMonth= "(//div[contains(@class,'ant-picker-cell-inner')][normalize-space()='26'])[2]";
    public static String ErrorMsgAddProject= "(//p[contains(@class,'add-project-err-msg')])[2]";
    public static String SelectedDatePastDate= "//div[normalize-space()='16']";
    public static String ValidationMessageStartDate= "//div[@class='from-group']//label[normalize-space()='Start Date']//..//p[@class='add-project-err-msg']";
    public static String ValidationMessage= "//div[@class='from-group']//label[normalize-space()='End Date']//..//p[@class='add-project-err-msg']";


}
