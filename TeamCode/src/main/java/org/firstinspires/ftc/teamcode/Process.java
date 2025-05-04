package org.firstinspires.ftc.teamcode;


/**
 * This is the Process class for Project Overload. This class represents processes that can
 * be run by subsystems, allowing subsystems to properly handle object dependencies as well
 * as properly queue multiple processes.
 *
 * @author Asher Childress - 9161 Overload
 */
public class Process {
    private String name;
    private ProcessStatus status;
    private Timer timer;
    
   /**
     * Constructor for a basic process.
     * 
     * @param name The name of the process
     */
    public BasicProcess(String name) {
        this.name = name;
        this.status = ProcessStatus.NOT_STARTED;
        this.statusChecker = null;
        this.timer = new Timer();
    }
    public void setStatus(ProcessStatus status) {
        this.status = status;
    }
  
    public void startProcess(String processName) {
      TimedProcess process = processes.get(processName);
      if (process != null) {
          process.start();
      }
    }
    public TimedProcess removeProcess(String processName) {
        return processes.remove(processName);
    }

}
