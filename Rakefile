require 'rake'
require 'rake/testtask'

task :default => [:test_units]

desc "Run basic tests"
Rake::TestTask.new("test_units") { |t|
  t.test_files = Dir.glob("src/test/ruby/*Test.rb")
  t.verbose = true
  t.warning = true
}
