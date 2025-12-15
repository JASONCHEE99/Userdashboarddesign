import { useState } from 'react';
import { TableEntry } from '../types/table';
import { TableRow } from './table/TableRow';
import { Pagination } from './table/Pagination';

interface DataTableProps {
  data: TableEntry[];
  itemsPerPage?: number;
}

export function DataTable({ data, itemsPerPage = 5 }: DataTableProps) {
  const [currentPage, setCurrentPage] = useState(1);
  const [openDropdown, setOpenDropdown] = useState<string | null>(null);

  const totalPages = Math.ceil(data.length / itemsPerPage);
  const startIndex = (currentPage - 1) * itemsPerPage;
  const paginatedData = data.slice(startIndex, startIndex + itemsPerPage);

  const handleToggleDropdown = (id: string) => {
    setOpenDropdown(openDropdown === id ? null : id);
  };

  const handlePageChange = (page: number) => {
    setCurrentPage(page);
    setOpenDropdown(null); // 关闭任何打开的下拉菜单
  };

  return (
    <div className="bg-white rounded-xl shadow-sm border border-gray-200">
      {/* Table Header */}
      <div className="px-6 py-4 border-b border-gray-200">
        <div className="flex items-center justify-between">
          <div>
            <h2 className="text-gray-900">Recent Projects</h2>
            <p className="text-gray-600">Manage and track your ongoing projects</p>
          </div>
          <button className="px-4 py-2 border border-gray-300 rounded-lg hover:bg-gray-50 transition-colors">
            Filter
          </button>
        </div>
      </div>

      {/* Table */}
      <div className="overflow-x-auto">
        <table className="w-full">
          <thead className="bg-gray-50 border-b border-gray-200">
            <tr>
              <th className="px-6 py-3 text-left text-gray-700">ID</th>
              <th className="px-6 py-3 text-left text-gray-700">Project</th>
              <th className="px-6 py-3 text-left text-gray-700">Client</th>
              <th className="px-6 py-3 text-left text-gray-700">Status</th>
              <th className="px-6 py-3 text-left text-gray-700">Progress</th>
              <th className="px-6 py-3 text-left text-gray-700">Amount</th>
              <th className="px-6 py-3 text-left text-gray-700">Date</th>
              <th className="px-6 py-3 text-left text-gray-700">Actions</th>
            </tr>
          </thead>
          <tbody className="divide-y divide-gray-200">
            {paginatedData.map((entry) => (
              <TableRow
                key={entry.id}
                entry={entry}
                openDropdown={openDropdown}
                onToggleDropdown={handleToggleDropdown}
              />
            ))}
          </tbody>
        </table>
      </div>

      {/* Pagination */}
      <Pagination
        currentPage={currentPage}
        totalPages={totalPages}
        totalItems={data.length}
        itemsPerPage={itemsPerPage}
        onPageChange={handlePageChange}
      />
    </div>
  );
}
