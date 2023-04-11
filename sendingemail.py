# Import modules
import smtplib, ssl , sys
# Get the first command line argument
variable_name = sys.argv[1]
## email.mime subclasses
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
### Add new subclass for adding attachments
##############################################################
from email.mime.application import MIMEApplication
##############################################################
## The pandas library is only for generating the current date, which is not necessary for sending emails
#import pandas as pd

# Define the HTML document
html = '''
    <html>
        <body>
            <h1 style="color:Green;">GridApp Android_CICD Pipeline Reports..!</h1>
            <p>Hello team..!! <br/> please find the job artifacts here!</p>
            <p><strong style="color: blue;">APK file download link :</strong> {} </p> <br/>
        </body>
    </html>
    '''.format(variable_name)

# Define a function to attach files as MIMEApplication to the email
##############################################################
def attach_file_to_email(email_message, filename):
    # Open the attachment file for reading in binary mode, and make it a MIMEApplication class
    with open(filename, "rb") as f:
        file_attachment = MIMEApplication(f.read())
    # Add header/name to the attachments    
    file_attachment.add_header(
        "Content-Disposition",
        f"attachment; filename= {filename}",
    )
    # Attach the file to the message
    email_message.attach(file_attachment)
##############################################################    

# Set up the email addresses and password. Please replace below with your email address and password
email_from = 'XXXXX'
password = 'XXXXX'
email_to = ['recipient1@example.com', 'recipient2@example.com', 'recipient3@example.com']
#! add above line to send multiple email's
# Generate today's date to be included in the email Subject
#date_str = pd.Timestamp.today().strftime('%Y-%m-%d')

# Create a MIMEMultipart class, and set up the From, To, Subject fields
email_message = MIMEMultipart()
email_message['From'] = email_from
email_message['To'] = ', '.join(email_to)
email_message['Subject'] = 'Gitlab_Grid App_CICD Pipeline Reports'

# Attach the html doc defined earlier, as a MIMEText html content type to the MIME message
email_message.attach(MIMEText(html, "html"))

# Attach more (documents)
##############################################################
attach_file_to_email(email_message, 'app/lint/reports/lint-results-debug.html')
##############################################################
# Convert it as a string
email_string = email_message.as_string()

# Connect to the Gmail SMTP server and Send Email
context = ssl.create_default_context()
with smtplib.SMTP_SSL("smtp.gmail.com", 465, context=context) as server:
    server.login(email_from, password)
    server.sendmail(email_from, email_to, email_string)
