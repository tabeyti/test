/**
 * Kills any process instances matching the provided name.
 * @param  procName - the name of the process to kill.
 */
def call(procName) {
  def iter = 0
  while (iter < 2) {
    def command = """python - <<EOF
import psutil
for proc in psutil.process_iter():
    if proc.name() == '${procName}':
      print 'Found process {} with PID {}. Terminating...'.format('${procName}', proc.pid)
      proc.kill()
EOF"""
    try {
      sh command
      return
    }
    catch(Exception e) {
      sh 'pip install psutil'
      iter++
      continue
    } 
  }   
}