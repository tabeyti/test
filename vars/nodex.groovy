/**
 * Extends the 'node' step by adding 'timestamps' step
 * automatically.
 * @param  label   - standard node label.
 * @param  closure - standard node closure to execute.
 */

def call(label, closure) {
  timestamps {
    node(label) {
      closure()
    }
  }
}