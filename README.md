Data Scientist Test
===================

Note: instructions are given to Ubuntu users, if you use windows or mac adapt them to your operating system

1. Fork and clone this repo https://github.com/javihm77/data_scientist

        (a fork of this original repo: https://github.com/DataTests/data_engineer )
        
        $ sudo apt-get update
        $ sudo apt-get install git
        $ sudo apt-get install xclip
        $ git --version --> to check git version installed
        $ git config --global user.name "username"
        $ git config --global user.email "user email"
        $ ssh-keygen
        $ cat ~/.ssh/id_rsa.pub
        $ git clone https://github.com/javihm77/data_scientist

2. Start the Vagrant environment and log in.

        $ sudo apt-get install virtualbox
        $ sudo apt-get install virtualbox-dkms
        $ cd data_scientist
        $ vagrant init
        $ vagrant up
        $ vagrant ssh
        
3. Install java runtime environment in vagrant environment (Ubuntu server 14.04)
        
        $ sudo apt-get update
        $ sudo apt-get install default-jdk
        
4. Run the programm "Test" with the next functions in vagrant environment:

    a. Get the dataset available [saved in repository as dataset.txt].

    b. Print out the mean, mode, median and standard deviation for values in
       column 4.

    c. Measure and inform about the correlation between column 1 and 3.
    
        $ java Test

4. Soon you will see updates to Data scientist test in original repo after master accepts pull request made by javihm77


If you want to generate another dataset obtain it from this URL
[here]: https://www.random.org/integers/?num=100&min=1&max=100&col=4&base=10&format=plain&rnd=new
