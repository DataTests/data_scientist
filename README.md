Data Scientist Test
===================

1. Fork and clone this repo.
        https://github.com/javihm77/data_scientist
        
        (a fork of this original repo: https://github.com/DataTests/data_engineer )

2. Start the Vagrant environment and log in.

        $ vagrant up
        $ vagrant ssh
        
3. Install java runtime environment in vagrant environment (Ubuntu server 14.04)
        $ sudo apt-get update
        $ sudo apt-get install default-jdk
        
4. Run the programm "Test" with the next functions:

    a. Get the dataset available [saved in repository as dataset.txt].

    b. Print out the mean, mode, median and standard deviation for values in
       column 4.

    c. Measure and inform about the correlation between column 1 and 3.
    
        $ java Test

4. Push your code back to your fork at GitHub and submit a Pull Request to the
original repo.




[here]: https://www.random.org/integers/?num=100&min=1&max=100&col=4&base=10&format=plain&rnd=new
