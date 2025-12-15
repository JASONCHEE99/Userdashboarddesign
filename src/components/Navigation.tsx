import { useState } from 'react';
import { Search, Plus, Menu, ChevronDown, LayoutDashboard, FolderKanban, Settings, User, LogOut } from 'lucide-react';

export function Navigation() {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);

  return (
    <nav className="fixed top-0 left-0 right-0 bg-white border-b border-gray-200 z-50">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex items-center justify-between h-16">
          {/* Logo and Links */}
          <div className="flex items-center gap-8">
            <div className="flex items-center gap-2">
              <div className="w-8 h-8 bg-gradient-to-br from-blue-600 to-purple-600 rounded-lg flex items-center justify-center">
                <LayoutDashboard className="w-5 h-5 text-white" />
              </div>
              <span className="font-semibold text-gray-900">Dashboard</span>
            </div>
            
            <div className="hidden md:flex items-center gap-6">
              <a href="#" className="text-gray-700 hover:text-gray-900 transition-colors">
                Overview
              </a>
              <a href="#" className="text-gray-700 hover:text-gray-900 transition-colors">
                Projects
              </a>
              <a href="#" className="text-gray-700 hover:text-gray-900 transition-colors">
                Analytics
              </a>
              <a href="#" className="text-gray-700 hover:text-gray-900 transition-colors">
                Reports
              </a>
            </div>
          </div>

          {/* Search, Button, and Avatar */}
          <div className="flex items-center gap-4">
            {/* Search Field */}
            <div className="hidden sm:flex items-center relative">
              <Search className="absolute left-3 w-4 h-4 text-gray-400" />
              <input
                type="text"
                placeholder="Search..."
                className="pl-10 pr-4 py-2 bg-gray-50 border border-gray-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent w-64"
              />
            </div>

            {/* New Project Button */}
            <button className="flex items-center gap-2 px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors">
              <Plus className="w-4 h-4" />
              <span className="hidden sm:inline">New Project</span>
            </button>

            {/* Avatar Dropdown */}
            <div className="relative">
              <button
                onClick={() => setIsDropdownOpen(!isDropdownOpen)}
                className="flex items-center gap-2 hover:bg-gray-50 rounded-lg p-1 transition-colors"
              >
                <div className="w-9 h-9 rounded-full bg-gradient-to-br from-purple-500 to-pink-500 flex items-center justify-center">
                  <span className="text-white">JD</span>
                </div>
                <ChevronDown className="w-4 h-4 text-gray-600 hidden sm:block" />
              </button>

              {/* Dropdown Menu */}
              {isDropdownOpen && (
                <div className="absolute right-0 mt-2 w-56 bg-white rounded-lg shadow-lg border border-gray-200 py-1">
                  <div className="px-4 py-3 border-b border-gray-100">
                    <p className="font-medium text-gray-900">John Doe</p>
                    <p className="text-gray-500">john.doe@example.com</p>
                  </div>
                  <button className="w-full px-4 py-2 text-left text-gray-700 hover:bg-gray-50 flex items-center gap-3">
                    <User className="w-4 h-4" />
                    Profile
                  </button>
                  <button className="w-full px-4 py-2 text-left text-gray-700 hover:bg-gray-50 flex items-center gap-3">
                    <FolderKanban className="w-4 h-4" />
                    My Projects
                  </button>
                  <button className="w-full px-4 py-2 text-left text-gray-700 hover:bg-gray-50 flex items-center gap-3">
                    <Settings className="w-4 h-4" />
                    Settings
                  </button>
                  <div className="border-t border-gray-100 mt-1 pt-1">
                    <button className="w-full px-4 py-2 text-left text-red-600 hover:bg-gray-50 flex items-center gap-3">
                      <LogOut className="w-4 h-4" />
                      Sign Out
                    </button>
                  </div>
                </div>
              )}
            </div>

            {/* Mobile Menu Button */}
            <button className="md:hidden p-2 hover:bg-gray-50 rounded-lg">
              <Menu className="w-5 h-5 text-gray-700" />
            </button>
          </div>
        </div>
      </div>
    </nav>
  );
}
