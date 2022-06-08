set search_path to foundation_sql;

insert into user_roles (name) values ('Admin'), ('Premium User'), ('Basic User');

insert into app_users (first_name, last_name, email, username, password, role_id)
values 
('Marty', 'McChickenNugget', 'mcnugget@tendy.com', 'mcdouble', 'mcnugget123', 1),
('angie', 'applepie', 'apple123@tendy.com', 'goodpie', 'pie123', 1),
('brandon', 'buger', 'burger123@tendy.com', 'coldburger', 'burger123', 2),
('cally', 'chocolate', 'chocolate123@tendy.com', 'brokenicecream', 'icecream123', 2),
('devin', 'doublepatty', 'doublepatty123@tendy.com', 'hardpatty', 'patty123', 3),
('eric', 'elderlydiscount', 'discount123@tendy.com', 'nodiscount', 'discount123', 3);


insert into foundation_steps (steps, difficulty)
values
('step 1: Check your system requirements to ensure that you can run WSL, bash, or a linux distribution to run commands on your CLI', 1),
('Step 2: Create a directory using mkdir directoryName', 1),
('Step 3: Move to that directory using cd directoryName', 1),
('Step 4: open your browser, navigate to github and create a github account', 1),
('Step 5: open a new tab and navigate to git and download', 1),
('Step 5: go back to the github and click on- create a repository', 1),
('Step 6: navigate back to your shell and check your version of git using the command: git - - version', 1),
('Step 7: run the command: git init', 1),
('Step 8: add files to your repository with: git add fileName', 1),
('Step 9: commit files and add a message with: git commit -m here is my file', 1),
('Step 10: connect to a remote using- git remote add origin locatiion', 1);
